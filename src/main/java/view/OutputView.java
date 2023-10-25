package view;

import java.util.List;

import model.BallStrikeNothing;
import view.InputView;

public class OutputView {
    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";
    static final String NOTHING = "낫싱";
    public static final String CORRECT_3NUMBER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHOOES_RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_SET = "게임 종료";

    InputView inputView = new InputView();
    BallStrikeNothing ballStrikeNothing;

    public void printResult() {
        System.out.println(OutputFormat()); // format 출력

    }
    public String OutputFormat() {
        StringBuilder sb = new StringBuilder(32);
        if (ballStrikeNothing.ball > 0) {
            sb.append(ballStrikeNothing.ball + BALL + " ");
        }
        if (ballStrikeNothing.strike > 0) {
            sb.append(ballStrikeNothing.strike + STRIKE);
            sb.append(CORRECT_3NUMBER);
        }
        if (ballStrikeNothing.ball == 3) {
            sb.append(NOTHING);
        }
        return sb.toString();
    }

    public String PrintReStart() {
        String inputCode = "";
        if (ballStrikeNothing.strike == inputView.NUMBER_LENGTH) {
            System.out.println(inputView.CHOOES_RESTART_OR_EXIT);
            inputCode = inputView.ProgramReStartOrExit();
            System.out.println(inputCode);
        }
        return inputCode;
    }
}
