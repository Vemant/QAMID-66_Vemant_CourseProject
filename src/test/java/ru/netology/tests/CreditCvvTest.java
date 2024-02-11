package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class CreditCvvTest {
    CardFieldsPage cardFieldsPage = new CardFieldsPage();

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

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    //    ========= НИЖЕ БАГ НАДПИСЬ НЕ ТАМ ============
    @Test
    @DisplayName("Should get error, " +
            "empty CVV field")
    public void errorCreditEmptyCvv() {
        var cardInfo = DataHelper.generateEmptyCvvCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyCvv(
                "Поле обязательно" +
                        " для заполнения"
        );
    }

    @Test
    @DisplayName("Should get error, " +
            "2 symbols in CVV")
    public void errorCreditInvalidCvv() {
        var cardInfo = DataHelper.generateErrorCvvCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyCvv(
                "Неверный формат"
        );
    }
}
