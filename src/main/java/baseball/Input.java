package baseball;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<Character> numbers() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<Character> inputNumber = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num < '0' || num > '9')
                break;
            inputNumber.add(num);
        }
        if (!inputCheck(inputNumber))
            inputNumber.clear();
        return inputNumber;
    }


    private boolean inputCheck(List<Character> numbers) {
        try {
            if (numbers.size() == 3)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
