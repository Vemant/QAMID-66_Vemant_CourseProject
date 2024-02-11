package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class CreditGeneralValidTest {
    CardFieldsPage cardFieldsPage = new CardFieldsPage();
    String approvedStatus = "APPROVED";

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
    @DisplayName("Should successful make credit, all values is valid")
    void validApprovedCredit() {
        var cardInfo = DataHelper.generateValidApprovedCard();
        cardFieldsPage.verifyCard(cardInfo);
        var paymentStatus = SQLHelper.getPaymentTransactionStatus();
        Assertions.assertEquals(approvedStatus, paymentStatus);
        cardFieldsPage.verifyTitleNotification(
                "Успешно"
        );
        cardFieldsPage.verifyContentNotification(
                "Операция одобрена Банком."
        );
    }


}
