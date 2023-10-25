package baseball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();

    public List<Integer> numbers() {
        List<Integer> inputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
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

    public int newGameCheck() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            if (input.length() != 1)
                throw new IllegalArgumentException();
            int newgame = Integer.parseInt(input);
            if (newgame == 1) {
                return 1;
            } else if (newgame == 2) {
                return 2;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return 2;
        }
    }
}
