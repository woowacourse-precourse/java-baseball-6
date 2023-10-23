package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if (userInput > 999 || userInput < 123) {
            throw new IllegalArgumentException("1부터 9까지 서로다른 3자리 수로 입력해야합니다.");
        }
        Set<Character> digits = new HashSet<>();
        for (char digit : Integer.toString(userInput).toCharArray()) {
            if (digits.contains(digit)) {
                throw new IllegalArgumentException("중복되지 않은 3자리 숫자를 입력하세요.");
            }
            digits.add(digit);
        }
        System.out.println(digits);
    }
}
