package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Player {
    private static final int NUMBER_OF_DIGITS = 3;

    public List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return convertInputToList(input);
    }

    private List<Integer> convertInputToList(String input) {
        if (input.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException(NUMBER_OF_DIGITS + "자리의 숫자를 입력해주세요.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            // 입력이 숫자가 아닌 경우 예외 처리
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }

            // 입력을 숫자로 변환
            int number = ch - '0';

            // 중복된 숫자 예외 처리
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            } else if (numbers.contains(0)) { // 0이 포함된 경우 예외 처리
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
            }
            numbers.add(number);
        }
        return numbers;
    }

    // 볼, 스트라이크 계산 후 결과 출력
    public void showResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) System.out.print(ball + "볼 ");
            if (strike > 0) System.out.print(strike + "스트라이크");
            System.out.println();
        }
    }

    public void win(int strike) {
        System.out.println(strike + "스트라이크");
        System.out.println(NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료"); // all strike인 경우 게임 종료 문구 출력
    }

    // 게임 재실행 여부 확인
    public boolean choiceRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        // 입력이 1 또는 2가 아닌 경우 예외 처리
        if ("1".equals(choice) || "2".equals(choice)) {
            if ("2".equals(choice)) System.out.println("게임 종료"); // 2가 입력된 경우 게임 종료 문구 출력
            return "1".equals(choice);
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
