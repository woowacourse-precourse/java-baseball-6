package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String answer = generateAnswer();

    public void start() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            validateInput(input);
            if (isCorrect(input)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String generateAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : computer) {
            sb.append(number);
        }
        return sb.toString();
    }

    private void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0을 포함한 숫자를 입력하셨습니다.");
        }
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }

    private boolean isCorrect(String input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < input.length(); i++) {
            int idx = answer.indexOf(input.charAt(i));
            if (idx == i) {
                strike++;
            } else if (idx != -1) {
                ball++;
            }
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    public boolean isEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (Console.readLine().equals("1")) {
            return false;
        }
        return true;
    }
}
