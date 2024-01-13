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

public class CreditYearTest {
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

    // Валидный тест, ГОД 24 (крайнее валидное значение)
    // НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 24
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Year = 24")
    public void successExtremeValidValueYear24() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("24");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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

    // Валидный тест, ГОД 25 (крайнее валидное значение)
    //    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 25
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Year = 25")
    public void successExtremeValidValueYear25() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("25");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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

    // Валидный тест, ГОД 27 (крайнее валидное значение)
    //    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 28
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Year = 27")
    public void successExtremeValidValueYear27() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("27");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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

    // Валидный тест, ГОД 28 (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 28
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Year = 28")
    public void successExtremeValidValueYear28() {
        $(byText("Купить в кредит")).click();
        $(byText("Кредит по данным карты"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("03");
        $(byText("Год")).parent()
                .find("input")
                .setValue("28");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест ГОД, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД:
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "empty year field")
    public void errorEmptyYearField() {
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
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Поле " +
                                "обязательно для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ НАДПИСЬ НЕ ТАМ ============
    // Невалидный тест ГОД, 23 (крайнее невалидное значение)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 23
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "year = 23")
    public void errorYearIs23() {
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
                .setValue("23");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверно указан " +
                                "срок действия карты"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ГОД, 29 (крайнее невалидное значение)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 29
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "year = 29")
    public void errorYearIs29() {
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
                .setValue("29");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверно указан " +
                                "срок действия карты"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ГОД, 5
    // (крайнее невалидное значение кол-ва символов)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 5
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "year = 5")
    public void errorYearIs5Without0() {
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
                .setValue("5");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    |||||||||| БЫЛ НЕПОИСК ||||||||||||
    // Невалидный тест ГОД, 123
    // (крайнее невалидное значение кол-ва символов)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 267
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should change value and print success, " +
            "3 symbols in year")
    public void changeValueAndSuccessThreeSymbolsInYear() {
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
                .setValue("267")
                .shouldHave(Condition.value
                        ("26"));
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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

    // Невалидный тест ГОД,
    // комбинация валидной длины латинских символов и цифр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 5h
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "numbers and latin symbols in year field")
    public void errorYearFieldNumbersAndLatinSymbols() {
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
                .setValue("5h");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ГОД,
    // комбинация валидной длины кириллических символов и цифр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 5д
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "numbers and cyrillic symbols in year field")
    public void errorYearFieldNumbersAndCyrillicSymbols() {
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
                .setValue("5д");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ГОД,
    // комбинация валидной длины знаков препинания и цифр
//    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 5?
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "numbers and punctuation marks in year field")
    public void errorYearFieldNumbersAndPunctMarksSymbols() {
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
                .setValue("5?");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}