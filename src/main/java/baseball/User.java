package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
    ArrayList<Integer> numbers = new ArrayList<>();

    private static void validate(String input) {
        // 3자리 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        // 0-9 숫자인지 확인
        for (int i = 0; i < input.length(); i++) {
            int temp = (int) input.charAt(i) - '0';
            if (temp > 10 || temp < 0) {
                throw new IllegalArgumentException("0부터 9까지의 숫자만 입력 가능합니다.");
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!temp.contains((int) input.charAt(i) - '0')) {
                temp.add((int) input.charAt(i) - '0');
            }
        }

        // 중복 여부 확인
        HashSet<Integer> numSet = new HashSet<>(temp);
        if(numSet.size() != temp.size()){
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    public void selectNumber() {
        this.numbers.clear();
        String input = Console.readLine();

        validate(input);

        for (int i = 0; i < input.length(); i++) {
            if (!this.numbers.contains((int) input.charAt(i) - '0')) {
                this.numbers.add((int) input.charAt(i) - '0');
            }
        }
    }
}
