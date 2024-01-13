package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PaymentGeneralValidTest {
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

    //    Валидный тест
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment")
    public void shouldMakePaymentValidValues() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(".notification__title")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("Успешно"));
        $(".notification__content")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("Операция одобрена " +
                        "Банком."));
    }
}
