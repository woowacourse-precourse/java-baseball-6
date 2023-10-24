package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class DisplayBoard {

    static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = validateInputBalls(readLine());
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private static String validateInputBalls(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("입력된 길이가 3이 아닙니다");
        }
        List<Integer> numbers = new ArrayList<>();
        for(char ch : input.toCharArray()) {
            if(!Character.isDigit(ch) || ch == '0') {
                throw new IllegalArgumentException("입력은 1~9 사이의 숫자입니다");
            }
            int curr = ch - '0';
            if(numbers.contains(curr)) {
                throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다");
            }
            numbers.add(curr);
        }

        return input;
    }

    static int inputEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = validateInputEnd(readLine());
        return Integer.parseInt(input);
    }

    private static String validateInputEnd(String input) {
        if(input.equals("1") || input.equals("2")) {
            return input;
        }
        throw new IllegalArgumentException("게임이 끝난 경우 1 혹은 2만 입력 가능합니다.");
    }


}
