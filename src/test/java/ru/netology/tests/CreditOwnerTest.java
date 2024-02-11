package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardFieldsPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class CreditOwnerTest {
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

    // Невалидный тест ВЛАДЕЛЕЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty Owner field")
    public void errorEmptyOwnerField() {
        var cardInfo = DataHelper.generateCardOwnerEmptyRestValid();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
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
        var cardInfo = DataHelper.generateCardOwnerInvalidWithoutSpacesRestValid();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
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
        var cardInfo = DataHelper.generateCardOwnerInvalidTwoSpacesRestValid();
        cardFieldsPage.verifyCard(cardInfo);
        cardFieldsPage.verifyOwner(
                "Неверный формат"
        );
    }
}
