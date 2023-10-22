package baseball;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Character> number = new ArrayList<>();
    private final int length = 3;

    public Number() {
    }

    public Number(String input) {
        if (input.length() != length) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }

        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
            if (number.contains(c)) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
            number.add(c);
        }
    }

    public char getNumber(int index) {
        return number.get(index);
    }

    public int getLength() {
        return number.size();
    }

    public void clearNumber() {
        number.clear();
    }

    public void addNumber(int num) {
        char addChar = (char) (num + '0');
        if (!number.contains(addChar)) {
            number.add(addChar);
        }
    }

    public void printNum() {
        System.out.print("컴퓨터: ");
        number.forEach(character -> System.out.print(character));
        System.out.println(); // 줄바꿈 추가=
    }

    public int matchNumber(char num) {
        return number.indexOf(num);
    }
}
