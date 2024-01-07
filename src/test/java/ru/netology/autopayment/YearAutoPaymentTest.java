package ru.netology.autopayment;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YearAutoPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест ГОД, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ГОД: empty

    @Test
    @DisplayName("Should get error, " +
            "empty year field")
    public void errorEmptyYearField() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataGenerator.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidMonth());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Поле " +
                                "обязательно для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ГОД, 29 (крайнее невалидное значение)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: invalid
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "year is invalid")
    public void errorYearIsInvalid() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataGenerator.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomErrorYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверно указан " +
                                "срок действия карты"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}
