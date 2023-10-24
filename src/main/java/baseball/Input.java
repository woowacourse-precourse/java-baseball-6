package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<Integer> numbers() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<Integer> inputNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num < '0' || num > '9')
                break;
            int value = Integer.parseInt(String.valueOf(num));
            inputNumber.add(value);
        }
        if (!inputCheck(inputNumber))
            inputNumber.clear();
        return inputNumber;
    }

    private boolean inputCheck(List<Integer> numbers) {
        try {
            if (numbers.size() == 3)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
