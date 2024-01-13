package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreditCvvTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void serUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    //    ========= НИЖЕ БАГ НАДПИСЬ НЕ ТАМ ============
    // Невалидный тест CVV, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "empty CVV field")
    public void errorEmptyCvvField() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Поле обязательно" +
                                " для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест CVV,
    // крайнее невалидное значение кол-ва символов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 45
    @Test
    @DisplayName("Should get error, " +
            "2 symbols in CVV")
    public void errorCvvTwoSymbols() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("45");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    |||||||||| БЫЛ НЕПОИСК ||||||||||||
    // Невалидный тест CVV, 4 символа
    // крайнее невалидное значение кол-ва символов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 4567
    @Test
    @DisplayName("Should get error, " +
            "4 symbols in CVV")
    public void errorCvvFourSymbols() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("4567")
                .shouldHave(Condition.value
                        ("456"));
        $(byText("Продолжить")).click();
        $(".notification__title")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("Успешно"));
        $(".notification__content")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("Операция одобрена " +
                        "Банком."));
    }

    // Невалидный тест CVV,
    // цифры + латсимволы
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 4j5
    @Test
    @DisplayName("Should get error, " +
            "numbers and latin symbols in CVV")
    public void errorCvvLatinSymbolsAndNumbers() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("4j5");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест CVV,
    // цифры + кирсимволы
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 4д5
    @Test
    @DisplayName("Should get error, " +
            "numbers and cyrillic symbols in CVv")
    public void errorCvvNumbersAndCyrillicSymbols() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("4д5");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест CVV,
    // цифры + знаки препинания
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 4&5
    @Test
    @DisplayName("Should get error, " +
            "numbers and punctuations in CVv")
    public void errorCvvNumbersAndPunctuations() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("4&5");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест CVV,
    // три пробела
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV:
    @Test
    @DisplayName("Should get error, " +
            "3 spaces in Cvv")
    public void errorCvvThreeSpaces() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("   ");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}