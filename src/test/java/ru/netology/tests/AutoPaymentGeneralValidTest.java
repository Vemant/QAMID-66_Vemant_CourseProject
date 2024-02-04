package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//import static ru.netology.data.SQLHelper.cleanAuthCodes;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentGeneralValidTest {
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

    @Test
    @DisplayName("Should successful make payment")
    void shouldMakePaymentValidValues() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardAllFieldsValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyTitleNotification(
                "Успешно"
        );
        CardFieldsPage.verifyContentNotification(
                "Операция одобрена Банком."
        );
    }
}
