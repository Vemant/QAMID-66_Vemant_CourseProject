package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentCvvTest {
    CardFieldsPage cardFieldsPage;

    @BeforeEach
    void setUp() {
        cardFieldsPage = open(
                "http://localhost:8080",
                CardFieldsPage.class);
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener(
                "allure",
                new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        cleanDatabase();
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
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardCvvEmptyRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyCvv(
                "Поле обязательно" +
                        " для заполнения"
        );
    }

    // Невалидный тест CVV,
    // крайнее невалидное значение кол-ва символов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    CVC/CVV: invalid
    @Test
    @DisplayName("Should get error, " +
            "2 symbols in CVV")
    public void errorCvvTwoSymbols() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardCvvInvalidRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyCvv(
                "Неверный формат"
        );
    }
}
