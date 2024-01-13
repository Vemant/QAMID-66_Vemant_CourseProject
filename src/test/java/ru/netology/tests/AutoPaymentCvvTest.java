package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoPaymentCvvTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
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
                .setValue(DataHelper.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidOwner());
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
                .setValue(DataHelper.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataHelper.getRandomErrorCvv());
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}
