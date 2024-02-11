package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class AutoPaymentOwnerTest {
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
            "empty Owner field")
    public void errorPaymentEmptyOwner() {
        var cardInfo = DataHelper.generateEmptyOwnerCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
                "Поле обязательно" +
                        " для заполнения"
        );
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============

    @Test
    @DisplayName("Should get error, " +
            "no spaces")
    public void errorPaymentNoSpacesOwner() {
        var cardInfo = DataHelper.generateNoSpacesErrorOwnerCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
                "Неверный формат"
        );
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    @Test
    @DisplayName("Should get error, " +
            "2 spaces")
    public void errorPaymentTwoSpacesOwner() {
        var cardInfo = DataHelper.generateTwoSpacesErrorOwnerCard();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
                "Неверный формат"
        );
    }
}
