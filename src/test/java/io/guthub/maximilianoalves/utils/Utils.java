package io.guthub.maximilianoalves.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public static String getBaseUrl() {
        return "https://serverest.dev";
    }
}
