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

public class AutoPaymentYearTest {
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
    // Невалидный тест ГОД, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ГОД: empty

    @Test
    @DisplayName("Should get error, " +
            "empty year field")
    public void errorEmptyYearField() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardYearEmptyRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyYear(
                "Поле " +
                        "обязательно для заполнения"
        );
    }

    // Невалидный тест ГОД невалидный
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ГОД: invalid
    @Test
    @DisplayName("Should get error, " +
            "year is invalid")
    public void errorYearIsInvalid() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardYearInvalidRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyYear(
                "Неверно указан " +
                        "срок действия карты"
        );
    }
}
