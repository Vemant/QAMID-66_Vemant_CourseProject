package ru.netology.credit;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OwnerCreditTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    // Валидный тест, ВЛАДЕЛЕЦ из 2-х символов, 1 пробел
    // (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: I V
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "2 symbols in Owner with 1 space")
    public void successExtremeValidValueOwner2symbols() {
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
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("I V");
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

    // Валидный тест, ВЛАДЕЛЕЦ из 3-х символов,
    // 1 пробел (крайнее валидное значение)
//    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV A
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "3 symbols in Owner with 1 space")
    public void successExtremeValidValueOwner3symbols() {
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
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IV A");
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

    // Валидный тест, ВЛАДЕЛЕЦ дефис слева от пробела,
    //    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV-AN IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "hyphen to the left of the space")
    public void successOneHyphenLeftOfSpace() {
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
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IV-AN IVANOV");
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
    // Валидный тест, ВЛАДЕЛЕЦ дефис справа от пробела,
    //    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVA-NOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "hyphen to the right of the space")
    public void successOneHyphenRightOfSpace() {
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
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IVAN IVA-NOV");
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
    // Валидный тест, ВЛАДЕЛЕЦ по 1-му дефису
    // слева и справа от пробела,
    //    НОМЕР КАРТЫ: 1111 2222 3333 4444
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV-AN IVA-NOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should successful make payment, " +
            "hyphen on both sides of the space")
    public void successOneHyphenBothSidesOfSpace() {
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
                .setValue("26");
        $(byText("Владелец")).parent()
                .find("input")
                .setValue("IV-AN IVA-NOV");
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

    // Невалидный тест ВЛАДЕЛЕЦ, поле пустое
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ:
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "empty Owner field")
    public void errorEmptyOwnerField() {
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
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Поле обязательно" +
                                " для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ, 1 латинский символ
    // (крайнее невалидное значение кол-ва символов)
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: N
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "1 symbol without space")
    public void errorOwner1symbol() {
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
                .setValue("N");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    // Невалидный тест ВЛАДЕЛЕЦ, пробел
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ:
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "1 space")
    public void errorOwnerSpace() {
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
                .setValue(" ");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Поле обязательно " +
                                "для заполнения"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов без пробелов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVANIVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "without space")
    public void errorOwnerWithoutSpace() {
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
                .setValue("IVANIVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
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
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IVA NOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "2 spaces")
    public void errorOwnerWithTwoSpaces() {
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
                .setValue("IVAN IVA NOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с дефисом без пробелов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN-IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "1 hyphen without spaces")
    public void errorOwnerOneHyphenWithoutSpaces() {
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
                .setValue("IVAN-IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с 2-мя дефисами без пробелов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN-IVA-NOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "2 hyphens without spaces")
    public void errorOwnerTwoHyphensWithoutSpaces() {
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
                .setValue("IVAN-IVA-NOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с 2-мя дефисами
    // слева от пробела
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV-A-N IVANOV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "2 hyphens to the left on the space")
    public void errorOwnerTwoHyphensLeftOfSpace() {
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
                .setValue("IV-A-N IVANOV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // валидное кол-во символов с 2-мя дефисами
    // справа от пробела
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN IV-AN-OV
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "2 hyphens to the right on the space")
    public void errorOwnerTwoHyphensRightOfSpace() {
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
                .setValue("IVAN IV-AN-OV");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // комбинация валидной длины из лат- и кирсимволов
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IVAN ИВАНОВ
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "latin and cyrillic symbols")
    public void errorOwnerLatinAndCyrillicSymbols() {
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
                .setValue("IVAN ИВАНОВ");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // комбинация валидной длины из латсимволов и цифр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV5N IVA72V
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "latin symbols and numbers")
    public void errorOwnerLatinSymbolsAndNumbers() {
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
                .setValue("IV5N IVA72V");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // комбинация валидной длины
    // из латсимволов и знаков препинания
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: IV?! IVAN%V
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "latin symbols and punctuations")
    public void errorOwnerLatinSymbolsAndPunctuations() {
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
                .setValue("IV?! IVAN%V");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // неверный регистр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: ivan ivanov
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "invalid case")
    public void errorOwnerInvalidCase() {
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
                .setValue("ivan ivanov");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }

    //    ========= НИЖЕ БАГ PASSED ПРИ БАГЕ ============
    // Невалидный тест ВЛАДЕЛЕЦ,
    // неверный регистр
    //    НОМЕР КАРТЫ: 5555 6666 7777 8888
//    МЕСЯЦ: 03
//    ГОД: 26
//    ВЛАДЕЛЕЦ: Ivan Ivanov
//    CVC/CVV: 456
    @Test
    @DisplayName("Should get error, " +
            "invalid case with capital letters")
    public void errorOwnerInvalidCaseCapitalLetters() {
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
                .setValue("Ivan Ivanov");
        $(byText("CVC/CVV")).parent()
                .find("input")
                .setValue("456");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent()
                .shouldHave(Condition.text("Неверный формат"),
                        Duration.ofSeconds(16))
                .shouldBe(Condition.visible);
    }
}