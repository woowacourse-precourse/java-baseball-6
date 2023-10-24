package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballGame {
    private static final int NUM_DIGITS = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_OPTION = "1";
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private boolean exitFlag = false;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    NumberGenerator numberGenerator = new NumberGenerator();

    public void startGame() { // Updated method name
        System.out.println(START_MESSAGE);
        computer = numberGenerator.generateRandomNumbers();
        while (!exitFlag) {
            player = numberGenerator.getInputNumber();
            printHint(computer, player);
        }
    }

    private void handleRestartOrExit() {
        String input = getInputRestartOrExit();
        if (input.equals(RESTART_OPTION)) {
            computer = numberGenerator.generateRandomNumbers();
            return;
        }
        exitFlag = true;
    }

    private String getInputRestartOrExit() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
        String input = Console.readLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private void printHint(List<Integer> answer, List<Integer> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(makeHint(strike, ball));
        if (strike == NUM_DIGITS) {
            System.out.println(THREE_STRIKE_MESSAGE);
            handleRestartOrExit();
        }
    }

    private String makeHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append(BALL_STR).append(strike).append(STRIKE_STR).append("\n");
                return sb.toString();
            }
            sb.append(strike).append(STRIKE_STR);
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append(BALL_STR);
            return sb.toString();
        }
        sb.append(NOTHING);
        return sb.toString();
    }

    private int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if (answer.get(idx).equals(input.get(idx))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if (!answer.get(idx).equals(input.get(idx)) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }
}
