package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DataHelper {
    private DataHelper() {
    }

    // НОМЕР КАРТЫ
    // Номер для валиндых тестов 1111 2222 3333 4444
    public static String getNumberOfSuccesses() {
        return "1111 2222 3333 4444";
    }

    // Номер для невалидных тестов 5555 6666 7777 8888
    public static String getNumberOfErrors() {
        return "5555 6666 7777 8888";
    }

    // Случайный невалидный номер
    public static String getRandomNumber() {
        var faker = new Faker();
        int cardLength = 0;
        String randomCard = "";
        while (cardLength != 19) {
            randomCard = faker.finance().creditCard();
            cardLength = randomCard.length();
        }
        return randomCard;
    }

    // Генерируем МЕСЯЦ
    public static String getRandomValidMonth() {
        var faker = new Faker();
        int month = faker.number().numberBetween(1, 13);
        String randomMonth = "";
        if (month < 10) {
            randomMonth = "0" + String.valueOf(month);
        } else {
            randomMonth = String.valueOf(month);
        }
        return randomMonth;
    }

    public static String getRandomErrorMonth() {
        var faker = new Faker();
        int randomMonth = (faker.number().numberBetween(13, 100));
        return String.valueOf(randomMonth);
    }

    // Генерируем ГОД
    public static String getRandomValidYear() {
        var faker = new Faker();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(faker.number().numberBetween(currentYear, currentYear + 6));
    }

    public static String getRandomErrorYear() {
        var faker = new Faker();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int lastYear = faker.number().numberBetween(currentYear - currentYear + 1, currentYear);
        int futureYear = faker.number().numberBetween(currentYear + 6, currentYear + 100);
        String randomYear = String.valueOf(lastYear | futureYear);
        return randomYear;
    }

    // Генерируем ВЛАДЕЛЕЦ
    public static String getRandomValidOwner() {
        var faker = new Faker();
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String getRandomErrorWithoutSpacesOwner() {
        var faker = new Faker();
        return faker.name().lastName();
    }

    public static String getRandomErrorWithTwoSpacesOwner() {
        var faker = new Faker();
        return faker.name().lastName() + " " +
                faker.name().firstName() + " " +
                faker.name().firstName();
    }

    // Генерируем CVV
    public static String getRandomValidCvv() {
        var faker = new Faker();
        return String.valueOf(faker.number().numberBetween(100, 1000));
    }

    public static String getRandomErrorCvv() {
        var faker = new Faker();
        return String.valueOf(faker.number().numberBetween(1, 100));
    }

    @Value
    public static class AuthInfo {
        String number;
        String month;
        String year;
        String owner;
        String cvv;
    }
}
