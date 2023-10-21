package baseball.baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        return readLine();
    }

    public String getEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        return readLine();
    }
}
