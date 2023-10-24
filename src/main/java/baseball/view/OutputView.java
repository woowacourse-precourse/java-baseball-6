package baseball.view;

import java.util.List;
import java.util.regex.Pattern;

import baseball.model.BallCount;
import camp.nextstep.edu.missionutils.Console;
import baseball.controller.Game;

import static baseball.controller.Game.setRestartOrExit;

public class OutputView {
    InputView number = new InputView();
    private static final int DIGITS = 3;
    BallCount BC = new BallCount();
    public static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    public static final String RESTART = "1";
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public void printHint(List<Integer> answer, List<Integer> input) {
        int strike = BC.countStrike(answer, input);
        int ball = BC.countBall(answer, input);

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

    public String inputRestartOrExit() {
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

}
