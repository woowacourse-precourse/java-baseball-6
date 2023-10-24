package view;

import java.util.List;
import view.InputView;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String CHOOES_RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    InputView inputView = new InputView();

    public void printResult(List<Integer> result) {
        System.out.println(OutputFormat(result)); // format 출력
        System.out.println(CHOOES_RESTART_OR_EXIT);
        inputView.ProgramReStartOrExit();
    }
    public String OutputFormat(List<Integer> result) {
        StringBuilder sb = new StringBuilder(524);
        if (result.get(0) > 0) { // 볼
            sb.append(result.get(0) + BALL);
        }
        if (result.get(1) > 0) { //스트라이크
            sb.append(result.get(1) + STRIKE);
        }
        if (result.get(2) == 3) { //낫싱
            sb.append(NOTHING);
        }
        return sb.toString();
    }
}
