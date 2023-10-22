package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseBallView {

    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String FINISH_INPUT_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private BaseBallView() {
    }

    public static BaseBallView create() {
        return new BaseBallView();
    }

    public void startGameView() {
        System.out.println(START_STRING);
    }

    public void resultGameView(String result) {
        System.out.println(result);
    }


    public String numbersInputView() {
        System.out.print(NUMBER_INPUT_STRING);

        return readLine();
    }

    public String continueInputView() {
        System.out.println(FINISH_INPUT_STRING);

        return readLine();
    }


}
