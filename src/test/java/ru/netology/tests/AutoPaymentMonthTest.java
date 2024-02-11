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

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест МЕСЯЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty month field")
    public void errorEmptyMonthField() {
        var cardInfo = DataHelper.generateCardMonthEmptyRestValid();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyMonth(
                "Поле обязательно для заполнения"
        );
    }

    // Невалидный тест МЕСЯЦ невалиден
//    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: random error
    @Test
    @DisplayName("Should get error, " +
            "error month")
    public void errorMonthIsInvalid() {
        var cardInfo = DataHelper.generateCardMonthInvalidRestValid();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyMonth(
                "Неверно указан " +
                        "срок действия карты"
        );
    }
}