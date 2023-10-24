package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int randomLen = 3;
    private List<Integer> randomInt;
    private List<Integer> userInt;
    private int strike;
    private int ball;
    private boolean isSolved;
    private boolean isFinished;

    public Game() {
        setRandomInt();
    }

    private void setRandomInt() {
        randomInt = new ArrayList<>();
        while (randomInt.size() < randomLen) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(randomNumber)) {
                randomInt.add(randomNumber);
            }
        }
    }

    public void getUserInt() {
        userInt = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUserInt(input);
        for (int j = 0; j < input.length(); j++) {
            userInt.add(input.charAt(j) - '0');
        }
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void printResult() {
        judgeUserInt();
        String result;
        if (ball > 0 && strike > 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (ball > 0 && strike == 0) {
            result = ball + "볼";
        } else if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        } else {
            result = "낫싱";
        }
        System.out.println(result);
        if (strike == randomLen) {
            isSolved = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void judgeUserInt() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < randomLen; i++) {
            if (randomInt.get(i).equals(userInt.get(i))) {
                strike++;
            } else if (randomInt.contains(userInt.get(i))) {
                ball++;
            }
        }
    }

    public void getUserChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateUserChoice(input);
        if (input.equals("2")) {
            isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    private void validateUserInt(String input) {
        if (input.length() != randomLen) {
            throw new IllegalArgumentException("input has to be 3 digits.");
        }
        for (int i = 0; i < input.length(); i++) {
            if ('1' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException("input has to be formed with digits between 1 to 9.");
            }
            if (input.lastIndexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("input has to be formed with different digits.");
            }
        }
    }

    private void validateUserChoice(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("input has to be either 1 or 2.");
        }
    }
}
