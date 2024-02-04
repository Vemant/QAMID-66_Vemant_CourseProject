package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentNumberTest {
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

    //    ========= НИЖЕ БАГ FAILED ПРИ УДАЧЕ ============
    // Невалидный тест НОМЕР КАРТЫ,
    // не предусмотренный сервером
    //    НОМЕР КАРТЫ: random
    @Test
    @DisplayName("Should get error, " +
            "non-provided card number")
    public void errorNonProvidedCardNumber() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardNumberInvalidRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyTitleNotification(
                "Ошибка"
        );
        CardFieldsPage.verifyContentNotification(
                "Ошибка! " +
                        "Банк отказал в проведении операции."
        );
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест НОМЕР КАРТЫ, поле пустое
    //    НОМЕР КАРТЫ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty card field")
    public void errorCardFieldEmpty() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardNumberEmptyRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyNumber(
                "Поле " +
                        "обязательно для заполнения"
        );
    }
}
