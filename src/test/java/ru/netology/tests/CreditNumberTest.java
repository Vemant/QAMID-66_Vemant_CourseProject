package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class CreditNumberTest {
    CardFieldsPage cardFieldsPage = new CardFieldsPage();
    String declinedStatus = "DECLINED";
    @BeforeEach
    void setUp() {
        cardFieldsPage = open(
                "http://localhost:8080",
                CardFieldsPage.class);
        cardFieldsPage.choiceCreditMethod();
        cardFieldsPage.creditFieldVisibility();
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

    @Test
    @DisplayName("Should declined credit")
    void validDeclinedCredit() {
        var cardInfo = DataHelper.generateValidDeclinedCard();
        cardFieldsPage.verifyCard(cardInfo);
        var paymentStatus = SQLHelper.getPaymentTransactionStatus();
        Assertions.assertEquals(declinedStatus, paymentStatus);
        cardFieldsPage.verifyTitleNotification(
                "Ошибка"
        );
        cardFieldsPage.verifyContentNotification(
                "Ошибка! " +
                        "Банк отказал в проведении операции."
        );
    }

    //    ========= НИЖЕ БАГ FAILED ПРИ УДАЧЕ ============
    @Test
    @DisplayName("Should get error, " +
            "non-provided card number")
    public void errorCreditRandomNumber() {
        var cardInfo = DataHelper.generateRandomNumberCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyTitleNotification(
                "Ошибка"
        );
        cardFieldsPage.verifyContentNotification(
                "Ошибка! " +
                        "Банк отказал в проведении операции."
        );
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    @Test
    @DisplayName("Should get error, " +
            "empty card field")
    public void errorCreditEmptyNumber() {
        var cardInfo = DataHelper.generateEmptyNumberCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyNumber(
                "Поле " +
                        "обязательно для заполнения"
        );
    }
}
