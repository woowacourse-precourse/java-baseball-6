package baseball.Controller;

import baseball.AnswerJudge;
import baseball.ComputerNumberGenerator;
import baseball.View.InputView;
import java.util.List;

public class GameController {
    private static final String END_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static List<Integer> ComputerNumber = ComputerNumberGenerator.generate();

    public GameController() {
        InputView.start();
    }

    public void run() {
        while (true) {
            play();
            if (!isContinue()) {
                break;
            }
        }
    }

    private void play() {
        String result = AnswerJudge.judge(InputView.UserInputView(), ComputerNumber);
        System.out.println(result);
        if (AnswerJudge.isWin(result)) {
            return;
        }
        play();
    }

    private boolean isContinue() {
        int choice = InputView.choice();
        if (choice == 1) {
            RegenerateComputerNumber();
            return true;
        }
        if (choice == 2) {
            System.out.println(END_MESSAGE);
            return false;
        }
        System.out.println("잘못된 입력입니다.");
        return isContinue();
    }

    private void RegenerateComputerNumber() {
        ComputerNumber = ComputerNumberGenerator.generate();
    }
}
