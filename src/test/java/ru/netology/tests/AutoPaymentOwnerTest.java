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

public class AutoPaymentOwnerTest {
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

    // Невалидный тест ВЛАДЕЛЕЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty Owner field")
    public void errorEmptyOwnerField() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardOwnerEmptyRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyOwner(
                "Поле обязательно" +
                        " для заполнения"
        );
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов без пробелов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: without space

    @Test
    @DisplayName("Should get error, " +
            "without space")
    public void errorOwnerWithoutSpace() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardOwnerInvalidWithoutSpacesRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyOwner(
                "Неверный формат"
        );
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с двумя пробелами
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: 2 spaces

    @Test
    @DisplayName("Should get error, " +
            "2 spaces")
    public void errorOwnerWithTwoSpaces() {
        CardFieldsPage.choicePaymentMethod();
        var cardInfo = DataHelper.generateCardOwnerInvalidTwoSpacesRestValid();
        CardFieldsPage.verifyCard(cardInfo);
        CardFieldsPage.verifyOwner(
                "Неверный формат"
        );
    }
}
