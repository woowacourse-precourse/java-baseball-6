package model;

import java.util.HashSet;
import java.util.Set;

public class NumberInput {
    private final static int SIZE = 3;

    private String inputNumber;

    public NumberInput(String inputNumber) {
        checkLength(inputNumber);
        checkDigit(inputNumber);
        checkDuplication(inputNumber);

        this.inputNumber = inputNumber;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public static void checkLength(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDigit(String inputNumber) throws IllegalArgumentException {
        for (int i = 0; i < inputNumber.length(); i++) {
            if(!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkDuplication(String inputNumber) throws IllegalArgumentException {
        Set<Integer> inputNumberSet = new HashSet<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumberSet.add(inputNumber.charAt(i) - '0');
        }

        if (inputNumberSet.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
