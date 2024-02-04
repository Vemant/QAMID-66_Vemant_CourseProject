package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CardFieldsPage {
    // Закладывание элементов страницы в переменные
    private final SelenideElement heading =
            $(byText("Путешествие дня"));
    private static final SelenideElement paymentTab =
            $(byText("Купить"));
    private final SelenideElement paymentTitle =
            $(byText("Оплата по карте"));
    private static final SelenideElement numberField =
            $(byText("Номер карты")).parent()
                    .find("input");
    private static final SelenideElement monthField =
            $(byText("Месяц")).parent()
                    .find("input");
    private static final SelenideElement yearField =
            $(byText("Год")).parent()
                    .find("input");
    private static final SelenideElement ownerField =
            $(byText("Владелец")).parent()
                    .find("input");
    private static final SelenideElement cvvField =
            $(byText("CVC/CVV")).parent()
                    .find("input");
    private static final SelenideElement verifyButton =
            $(byText("Продолжить"));

    private static final SelenideElement titleNotification =
            $(".notification__title");
    private static final SelenideElement contentNotification =
            $(".notification__content");

    // Метод, выбирающий способ оплаты
    public static void choicePaymentMethod() {
        paymentTab.shouldBe(Condition.visible,
                Duration.ofSeconds(16));
    }

    // Метод проверяющией, что поля ввода карты стали видимы
    public void cardFieldsVisibility() {
        paymentTitle.shouldBe(visible);
    }

    // Методы, проверяющие, что заголовки и надписи под полями видны
    public static void verifyNumber(String expectedText) {
        numberField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public static void verifyMonth(String expectedText) {
        monthField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public static void verifyYear(String expectedText) {
        yearField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public static void verifyOwner(String expectedText) {
        ownerField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public static void verifyCvv(String expectedText) {
        cvvField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public static void verifyTitleNotification(String expectedText) {
        titleNotification.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                Duration.ofSeconds(16));
    }

    public static void verifyContentNotification(String expectedText) {
        contentNotification.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    // Метод, вводящий данные в поля карт и нажимающий на кнопку
    public static void verifyCard(DataHelper.CardInfo info) {
        numberField.setValue(info.getNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        verifyButton.click();
    }

    public CardFieldsPage() {
        heading.shouldBe(visible);
    }
}