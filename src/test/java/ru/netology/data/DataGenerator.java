package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
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
    public static String getRandomNumber(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.finance().creditCard();
    }

    // Генерируем МЕСЯЦ
    public static int getRandomValidMonth(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.number().numberBetween(1, 13);
    }

    public static int getRandomErrorMonth(String locale) {
        var faker = new Faker(new Locale(locale));
        return (faker.number().numberBetween(13, 100)) &
                (faker.number().numberBetween(-99, 0));
    }

    // Генерируем ГОД
    public static int getRandomValidYear(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.number().numberBetween(24, 29);
    }

    public static int getRandomErrorYear(String locale) {
        var faker = new Faker(new Locale(locale));
        return (faker.number().numberBetween(-99, 24)) &
                (faker.number().numberBetween(29, 100));
    }

    // Генерируем ВЛАДЕЛЕЦ
    public static String generateOwner(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    // Генерируем CVV
    private static int generateCvv(String locale) {
        var faker = new Faker();
        return faker.number().numberBetween(100, 1000);
    }
}
