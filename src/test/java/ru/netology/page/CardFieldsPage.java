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
    private final SelenideElement paymentTab =
            $(byText("Купить"));
    private final SelenideElement creditTab =
            $(byText("Купить в кредит"));
    private final SelenideElement paymentTitle =
            $(byText("Оплата по карте"));
    private final SelenideElement creditTitle =
            $(byText("Кредит по данным карты"));
    private final SelenideElement numberField =
            $(byText("Номер карты")).parent()
                    .find("input");
    private final SelenideElement monthField =
            $(byText("Месяц")).parent()
                    .find("input");
    private final SelenideElement yearField =
            $(byText("Год")).parent()
                    .find("input");
    private final SelenideElement ownerField =
            $(byText("Владелец")).parent()
                    .find("input");
    private final SelenideElement cvvField =
            $(byText("CVC/CVV")).parent()
                    .find("input");
    private final SelenideElement verifyButton =
            $(byText("Продолжить"));

    private final SelenideElement titleNotification =
            $(".notification__title");
    private final SelenideElement contentNotification =
            $(".notification__content");

    public CardFieldsPage() {
        heading.shouldBe(visible);
    }

    // Метод, выбирающий способ оплаты
    public void choicePaymentMethod() {
        paymentTab.shouldBe(Condition.visible);
    }

    public void choiceCreditMethod() {
        creditTab.shouldBe(Condition.visible);
    }

    // Метод проверяющией, что поля ввода карты стали видимы
    public void paymentFieldVisibility() {
        paymentTitle.shouldBe(visible);
    }

    public void creditFieldVisibility() {
        creditTitle.shouldBe(visible);
    }

    // Методы, проверяющие, что заголовки и надписи под полями видны
    public void verifyNumber(String expectedText) {
        numberField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible);
    }

    public void verifyMonth(String expectedText) {
        monthField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible);
    }

    public void verifyYear(String expectedText) {
        yearField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible);
    }

    public void verifyOwner(String expectedText) {
        ownerField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible);
    }

    public void verifyCvv(String expectedText) {
        cvvField.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible);
    }

    public void verifyTitleNotification(String expectedText) {
        titleNotification.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    public void verifyContentNotification(String expectedText) {
        contentNotification.shouldHave(exactText(expectedText))
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(16));
    }

    // Метод, вводящий данные в поля карт и нажимающий на кнопку
    public void verifyCard(DataHelper.CardInfo info) {
        numberField.setValue(info.getNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        verifyButton.click();
    }
}