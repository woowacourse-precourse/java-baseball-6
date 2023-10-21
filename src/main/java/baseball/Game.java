package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
    private static final int DIGITS = 3;
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART = "1";
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private boolean exitFlag = false;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    Number number = new Number();

    public void gameStart() {
        System.out.println(START_SENTENCE);
        computer = number.setRandomNumbers();
        while (!exitFlag) {
            player = number.getInputNumber();
            printHint(computer, player);
        }
    }

    private void setRestartOrExit() {
        String input = inputRestartOrExit();
        if(input.equals(RESTART)) {
            computer = number.setRandomNumbers();
            return;
        }
        exitFlag = true;
    }

    private String inputRestartOrExit() {
        System.out.println(RESTART_OR_EXIT_SENTENCE);
        String input = Console.readLine();
        if(!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private void printHint(List<Integer> answer, List<Integer> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(makeHint(strike, ball));
        if(strike == DIGITS) {
            System.out.println(THREE_STRIKE_SENTENCE);
            setRestartOrExit();
        }
    }

    private String makeHint (int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if(strike != 0) {
            if(ball != 0) {
                sb.append(ball).append(BALL_STR).append(strike).append(STRIKE_STR).append("\n");
                return sb.toString();
            }
            sb.append(strike).append(STRIKE_STR);
            return sb.toString();
        }
        if(ball != 0) {
            sb.append(ball).append(BALL_STR);
            return sb.toString();
        }
        sb.append(NOTHING);
        return sb.toString();
    }

    private int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx).equals(input.get(idx))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(!answer.get(idx).equals(input.get(idx)) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

}