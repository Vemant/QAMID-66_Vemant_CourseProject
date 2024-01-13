package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CardFieldsPage {
    private final SelenideElement paymentTab =
            $(byText("Купить"));
    private final SelenideElement paymentTitle =
            $(byText("Оплата по карте"));
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
    private final SelenideElement errorNotification =
            $("[data-test-id='error-notification'] " +
                    ".notification__content");

    // Метод проверяющией, что поля ввода карты стали видимы
    public void cardFieldsVisibility() {
        paymentTitle.shouldBe(visible);
    }

    // Метод, проверяющий, что надпись об ошибке видна
    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(exactText(expectedText))
                .shouldBe(visible);
    }

    // Метод, вводящий данные в поля карт
    public CardFieldsPage validCard(DataHelper.AuthInfo info) {
        numberField.setValue(info.getNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        verifyButton.click();
        return new CardFieldsPage();
    }
}