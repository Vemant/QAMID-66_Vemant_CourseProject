package ru.netology.autopayment;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NumberAutoPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void serUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //    ========= НИЖЕ БАГ FAILED ПРИ УДАЧЕ ============
    // Невалидный тест НОМЕР КАРТЫ,
    // не предусмотренный сервером
    //    НОМЕР КАРТЫ: random
    @Test
    @DisplayName("Should get error, " +
            "non-provided card number")
    public void errorNonProvidedCardNumber() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataGenerator.getRandomNumber());
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
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(".notification__title")
                .shouldHave(Condition.text("Ошибка"),
                        Duration.ofSeconds(31))
                .shouldBe(Condition.visible);
        $(".notification__content")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("Ошибка! " +
                        "Банк отказал в проведении операции."));
//        $(".notification__content")
//                .shouldBe(Condition.visible,
//                        Duration.ofSeconds(16))
//                .shouldHave(exactText("Операция одобрена " +
//                        "Банком."));
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест НОМЕР КАРТЫ, поле пустое
    //    НОМЕР КАРТЫ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty card field")
    public void errorCardFieldEmpty() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
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
                .setValue(DataGenerator.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Номер карты")).parent()
                .shouldHave(Condition.text("Поле " +
                                "обязательно для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}
