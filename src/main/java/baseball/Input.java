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
            inputNumber.add(input.charAt(i));
        }

        return inputNumber;
    }
}
