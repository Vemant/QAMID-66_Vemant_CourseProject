package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoPaymentOwnerTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    // Невалидный тест ВЛАДЕЛЕЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    ВЛАДЕЛЕЦ: empty
    @Test
    @DisplayName("Should get error, " +
            "empty Owner field")
    public void errorEmptyOwnerField() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataHelper.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidYear());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Поле обязательно" +
                                " для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
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
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataHelper.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataHelper.getRandomErrorWithoutSpacesOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
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
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue(DataHelper.getNumberOfErrors());
        $(byText("Месяц")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidMonth());
        $(byText("Год")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidYear());
        $(byText("Владелец")).parent()
                .find("input")
                .setValue(DataHelper.getRandomErrorWithTwoSpacesOwner());
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue(DataHelper.getRandomValidCvv());
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

}
