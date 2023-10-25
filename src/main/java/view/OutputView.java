package view;

import model.BallStrikeNothing;

public class OutputView {
    final String STRIKE = "스트라이크";
    final String BALL = "볼";
    final String NOTHING = "낫싱";
    public static final String CORRECT_3NUMBER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_SET = "게임 종료";

    InputView inputView = new InputView();
    BallStrikeNothing ballStrikeNothing;

    public void printResult() {
        System.out.println(OutputFormat());
    }
    public String OutputFormat() {
        StringBuilder sb = new StringBuilder(32);
        if (ballStrikeNothing.ball > 0) {
            sb.append(ballStrikeNothing.ball + BALL + " ");
        }
        if (ballStrikeNothing.strike > 0) {
            sb.append(ballStrikeNothing.strike + STRIKE + "\n");
            sb.append(CORRECT_3NUMBER);
        }
        if (ballStrikeNothing.nothing == 3) {
            sb.append(NOTHING);
        }
        return sb.toString();
    }

    public String PrintReStart() {
        System.out.println(inputView.CHOOES_RESTART_OR_EXIT);
        String inputCode = inputView.ProgramReStartOrExit();
        System.out.println(inputCode);
        return inputCode;
    }
}
