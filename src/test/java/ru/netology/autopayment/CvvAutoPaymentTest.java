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

public class CvvAutoPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    //    ========= НИЖЕ БАГ НАДПИСЬ НЕ ТАМ ============
    // Невалидный тест CVV, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "empty CVV field")
    public void errorEmptyCvvField() {
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
                .setValue(DataGenerator.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidOwner());
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Поле обязательно" +
                                " для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест CVV,
    // крайнее невалидное значение кол-ва символов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    CVC/CVV: 45
    @Test
    @DisplayName("Should get error, " +
            "2 symbols in CVV")
    public void errorCvvTwoSymbols() {
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
                .setValue(DataGenerator.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomErrorCvv());
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}
