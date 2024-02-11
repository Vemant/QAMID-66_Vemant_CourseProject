package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentMonthTest {
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

    @Test
    @DisplayName("Should get error, " +
            "empty month field")
    public void errorPaymentEmptyMonth() {
        var cardInfo = DataHelper.generateEmptyMonthCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyMonth(
                "Поле обязательно для заполнения"
        );
    }

    // Невалидный тест МЕСЯЦ невалиден
    @Test
    @DisplayName("Should get error, " +
            "error month")
    public void errorPaymentInvalidMonth() {
        var cardInfo = DataHelper.generateErrorMonthCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyMonth(
                "Неверно указан " +
                        "срок действия карты"
        );
    }
}