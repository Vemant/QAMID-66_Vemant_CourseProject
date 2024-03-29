package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentYearTest {
    CardFieldsPage cardFieldsPage = new CardFieldsPage();
    @BeforeEach
    void setUp() {
        cardFieldsPage = open(
                "http://localhost:8080",
                CardFieldsPage.class);
        cardFieldsPage.choicePaymentMethod();
        cardFieldsPage.paymentFieldVisibility();
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
    @Test
    @DisplayName("Should get error, " +
            "empty year field")
    public void errorPaymentEmptyYear() {
        var cardInfo = DataHelper.generateEmptyYearCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyYear(
                "Поле " +
                        "обязательно для заполнения"
        );
    }

    @Test
    @DisplayName("Should get error, " +
            "year is invalid")
    public void errorPaymentInvalidYear() {
        var cardInfo = DataHelper.generateErrorYearCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyYear(
                "Неверно указан " +
                        "срок действия карты"
        );
    }
}
