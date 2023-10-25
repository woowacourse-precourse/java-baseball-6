package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
    private static final int DIGITS = 3;
    private static final String StartMessage= "숫자 야구 게임을 시작합니다.";
    private static final String rePlayNum = "1";
    private static final String ball = "볼 ";
    private static final String strike = "스트라이크 ";
    private static final String nothing = "낫싱";
    private static final String Clear = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String rePlayQ = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private boolean exitFlag = false;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    Number number = new Number();

    public void gameStart() {
        System.out.println(StartMessage);
        computer = number.getRandomNumbers();
        while (!exitFlag) {
            player = number.getInputNumber();
            printHint(computer, player);
        }
    }

    private void rePlayMessage() {
        String input = ReplayOrNot();
        if (input.equals(rePlayNum)) {
            computer = number.getRandomNumbers();
            return;
        }
        exitFlag = true;
    }

    private String ReplayOrNot() {
        System.out.println(rePlayQ);
        String input = Console.readLine();
        if (!RightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean RightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private void printHint(List<Integer> answer, List<Integer> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(getHint(strike, ball));
        if (strike == DIGITS) {
            System.out.println(Clear);
            rePlayMessage();
        }
    }

    private String getHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append(ball).append(strike).append(strike).append("\n");
                return sb.toString();
            }
            sb.append(strike).append(strike);
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append(ball);
            return sb.toString();
        }
        sb.append(nothing);
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
