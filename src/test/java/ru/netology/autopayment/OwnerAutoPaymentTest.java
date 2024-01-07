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

public class OwnerAutoPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    // Невалидный тест ВЛАДЕЛЕЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: empty

    @Test
    @DisplayName("Should get error, " +
            "empty Owner field")
    public void errorEmptyOwnerField() {
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
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Поле обязательно" +
                                " для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов без пробелов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: without space

    @Test
    @DisplayName("Should get error, " +
            "without space")
    public void errorOwnerWithoutSpace() {
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
                .setValue(DataGenerator.getRandomErrorWithoutSpacesOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с двумя пробелами
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: 2 spaces

    @Test
    @DisplayName("Should get error, " +
            "2 spaces")
    public void errorOwnerWithTwoSpaces() {
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
                .setValue(DataGenerator.getRandomErrorWithTwoSpacesOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

}
