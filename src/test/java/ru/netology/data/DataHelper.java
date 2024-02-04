package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Calendar;
import java.util.Locale;

public class DataHelper {
    private static final Faker faker =
            new Faker(new Locale("en"));

    private DataHelper() {
    }

    // В А Л И Д Н Ы Е  Д А Н Н Ы Е
    // ВАЛИДНЫЙ НОМЕР КАРТЫ
    // Номер для валиндых тестов 1111 2222 3333 4444
    public static String getNumberOfSuccesses() {
        return "1111 2222 3333 4444";
    }

    // Номер для невалидных тестов 5555 6666 7777 8888
    public static String getNumberOfErrors() {
        return "5555 6666 7777 8888";
    }

    // ВАЛИДНЫЙ МЕСЯЦ
    public static String getRandomValidMonth() {
//        var faker = new Faker();
        int cardMonth = 0;
        while (cardMonth == 0) {
            cardMonth = faker.number().numberBetween(-12, 13);
        }
        String randomCardMonth = "";
        if ((cardMonth > -10) && (cardMonth < 10)) {
            randomCardMonth = "0" + String.valueOf(cardMonth);
        } else {
            randomCardMonth = String.valueOf(cardMonth);
        }
        return randomCardMonth;
    }

    // ВАЛИДНЫЙ ГОД
    public static String getRandomValidYear() {
//        var faker = new Faker();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String randomYear = String.valueOf(faker.number()
                .numberBetween(currentYear, currentYear + 6));
        return randomYear.substring(
                randomYear.length() - 2,
                randomYear.length() - 1
        );
    }

    // ВАЛИДНЫЙ ВЛАДЕЛЕЦ
    public static String getRandomValidOwner() {
//        var faker = new Faker();
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    // ВАЛИДНЫЙ CVV
    public static String getRandomValidCvv() {
//        var faker = new Faker();
        int randomCvv = 0;
        while ((randomCvv > -100) && (randomCvv < 100)) {
            randomCvv = faker.number().numberBetween(-999, 1000);
        }
        return String.valueOf(randomCvv);
    }

    // Н Е В А Л И Д Н Ы Е  Д А Н Н Ы Е
    // НЕВАЛИДНЫЙ НОМЕР КАРТЫ
    // Случайный невалидный номер
    public static String getRandomNumber() {
//        var faker = new Faker();
        int cardLength = 0;
        String randomCard = "";
        while (cardLength != 19) {
            randomCard = faker.finance().creditCard();
            cardLength = randomCard.length();
        }
        return randomCard;
    }

    // НЕВАЛИДНЫЙ МЕСЯЦ
    public static String getRandomErrorMonth() {
//        var faker = new Faker();
        int randomMonth = 0;
        while ((randomMonth >= -12) && (randomMonth <= 12)) {
            randomMonth = faker.number().numberBetween(-100, 100);
        }
        return String.valueOf(randomMonth);
    }

    // НЕВАЛИДНЫЙ ГОД
    public static String getRandomErrorYear() {
//        var faker = new Faker();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int randYear = currentYear;
        while ((randYear >= currentYear)
                && (randYear <= currentYear + 6)) {
            randYear = faker.number().numberBetween
                    (10, currentYear + 100);
        }
        String randomYear = String.valueOf(randYear);
        return randomYear.substring(
                randomYear.length() - 2,
                randomYear.length() - 1
        );
    }

    // НЕВАЛИДНЫЙ ВЛАДЕЛЕЦ
    public static String getRandomErrorWithoutSpacesOwner() {
//        var faker = new Faker();
        return faker.name().lastName();
    }

    public static String getRandomErrorWithTwoSpacesOwner() {
        var faker = new Faker();
        return faker.name().lastName() + " " +
                faker.name().firstName() + " " +
                faker.name().firstName();
    }

    // НЕВАЛИДНЫЙ CVV
    public static String getRandomErrorCvv() {
//        var faker = new Faker();
        return String.valueOf(faker.number().numberBetween(-99, 100));
    }

    // О Б Ъ Е К Т Ы  К А Р Т
    // ВСЕ ПОЛЯ ВАЛИДНЫ
    public static CardInfo generateCardAllFieldsValid() {
        String number = getNumberOfSuccesses();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomValidOwner();
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.valueOf(getRandomValidMonth());
            }
        } else {
            month = Integer.valueOf(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }

    // НОМЕР КАРТЫ НЕВАЛИДЕН
    // Случайный номер
    public static CardInfo generateCardNumberInvalidRestValid() {
        String number = getRandomNumber();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomValidOwner();
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }

    // Поле номера пустое
    public static CardInfo generateCardNumberEmptyRestValid() {
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomValidOwner();
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                "",
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }
    // МЕСЯЦ НЕВАЛИДЕН
    // Месяц невозможный
    public static CardInfo generateCardMonthInvalidRestValid() {
        return new CardInfo(
                getNumberOfErrors(),
                getRandomErrorMonth(),
                getRandomValidYear(),
                getRandomValidOwner(),
                getRandomValidCvv()
        );
    }

    // Поле месяца пустое
    public static CardInfo generateCardMonthEmptyRestValid() {
        return new CardInfo(
                getNumberOfErrors(),
                "",
                getRandomValidYear(),
                getRandomValidOwner(),
                getRandomValidCvv()
        );
    }

    // ГОД НЕВАЛИДЕН
    // Год, не соответствующий требованиям
    public static CardInfo generateCardYearInvalidRestValid() {
        return new CardInfo(
                getNumberOfErrors(),
                getRandomValidMonth(),
                getRandomErrorYear(),
                getRandomValidOwner(),
                getRandomValidCvv()
        );
    }

    // Поле года пустое
    public static CardInfo generateCardYearEmptyRestValid() {
        return new CardInfo(
                getNumberOfErrors(),
                getRandomValidMonth(),
                "",
                getRandomValidOwner(),
                getRandomValidCvv()
        );
    }

    // ВЛАДЕЛЕЦ НЕВАЛИДЕН
    // Пробелов нет
    public static CardInfo generateCardOwnerInvalidWithoutSpacesRestValid() {
        String number = getNumberOfErrors();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomErrorWithoutSpacesOwner();
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }

    // Пробелов два
    public static CardInfo generateCardOwnerInvalidTwoSpacesRestValid() {
        String number = getNumberOfErrors();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomErrorWithTwoSpacesOwner();
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }

    // Поле владельца пустое
    public static CardInfo generateCardOwnerEmptyRestValid() {
        String number = getNumberOfErrors();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String cvv = getRandomValidCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                "",
                cvv
        );
    }

    // CVV НЕВАЛИДЕН
    public static CardInfo generateCardCvvInvalidRestValid() {
        String number = getNumberOfErrors();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomValidOwner();
        String cvv = getRandomErrorCvv();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                cvv
        );
    }

    // Поле cvv пустое
    public static CardInfo generateCardCvvEmptyRestValid() {
        String number = getNumberOfErrors();
        int month = 0;
        int year = Integer.parseInt(getRandomValidYear());
        String owner = getRandomValidOwner();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        if (year == currentYear) {
            while (month < currentMonth) {
                month = Integer.parseInt(getRandomValidMonth());
            }
        } else {
            month = Integer.parseInt(getRandomValidMonth());
        }
        return new CardInfo(
                number,
                Integer.toString(month),
                Integer.toString(year),
                owner,
                ""
        );
    }
    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String owner;
        String cvv;
    }
}
