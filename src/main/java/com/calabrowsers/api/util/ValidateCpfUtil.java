package com.calabrowsers.api.util;

public class ValidateCpfUtil {

    public static boolean cpfValidate(String cpf) {

        if (cpf == null) return false;

        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) return false;

        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int firstDigit = 11 - (sum % 11);
            if (firstDigit >= 10) firstDigit = 0;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int secondDigit = 11 - (sum % 11);
            if (secondDigit >= 10) secondDigit = 0;

            return cpf.charAt(9) == Character.forDigit(firstDigit, 10) &&
                    cpf.charAt(10) == Character.forDigit(secondDigit, 10);

        } catch (Exception e) {
            return false;
        }
    }
}
