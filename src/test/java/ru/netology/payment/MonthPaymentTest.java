package ru.netology.payment;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MonthPaymentTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    // Валидный тест, МЕСЯЦ 01 (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 01
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Month = 01")
    public void successExtremeValidValueMonth01() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("01");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
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

    // Валидный тест, МЕСЯЦ 02 (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 02
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Month = 02")
    public void successExtremeValidValueMonth02() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("02");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
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

    // Валидный тест, МЕСЯЦ 11 (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 11
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Month = 11")
    public void successExtremeValidValueMonth11() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("11");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
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

    // Валидный тест, МЕСЯЦ 12 (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 12
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "Month = 12")
    public void successExtremeValidValueMonth12() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("1111 2222 3333 4444");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("12");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
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
    // Невалидный тест МЕСЯЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ:
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "empty month field")
    public void errorEmptyMonthField() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Поле обязательно для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ НЕ ТА НАДПИСЬ ============
    // Невалидный тест МЕСЯЦ, 00 (крайнее невалидное значение)
//    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 00
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "month = 00")
    public void errorMonthIsZero() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("00");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверно указан " +
                                "срок действия карты"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    // Невалидный тест МЕСЯЦ, 13 (крайнее невалидное значение)
//    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 01
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "month = 13")
    public void errorMonthIs13() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("13");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверно указан " +
                                "срок действия карты"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    // Невалидный тест МЕСЯЦ, 3
    // (крайнее невалидное значение кол-ва символов)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 3
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "month = 3")
    public void errorMonthIs3Without0() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("3");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ НЕПОИСК ТОГО, ЧТО ЕСТЬ ============
    // Невалидный тест МЕСЯЦ, 123
    // (крайнее невалидное значение кол-ва символов)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 123
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should change value and print success, " +
            "3 symbols in month")
    public void changeValueAndSuccessThreeSymbolsInMonth() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("123");
        $(byText("Месяц"))
                .parent()
                .find("input")
                .find("value")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16))
                .shouldHave(exactText("12"));
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
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
    // Невалидный тест МЕСЯЦ, комбинация валидной длины
    // латинских символов и цифр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: h3
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "numbers and latin symbols in month field")
    public void errorMonthFieldNumbersAndLatinSymbols() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("h3");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест МЕСЯЦ, комбинация валидной длины
    // кириллических символов и цифр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: ш3
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "numbers and cyrillic symbols in month field")
    public void errorMonthFieldNumbersAndCyrillicSymbols() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("ш3");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест МЕСЯЦ, комбинация валидной длины
    // знаков препинания и цифр
//    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: !3
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, numbers " +
            "and punctuation marks in month field")
    public void errorMonthFieldNumbersAndPunctMarksSymbols() {
        $(byText("Купить")).click();
        $(byText("Оплата по карте"))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
        $(byText("Номер карты")).parent()
                .find("input")
                .setValue("5555 6666 7777 8888");
        $(byText("Месяц")).parent()
                .find("input")
                .setValue("!3");
        $(byText("Год")).parent()
                .find("input")
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

}