package baseball.Controller;

import baseball.AnswerJudge;
import baseball.ComputerNumberGenerator;
import baseball.UserGameInput;
import baseball.UserNumberInput;
import java.util.List;

public class GameController {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static List<Integer> ComputerNumber = ComputerNumberGenerator.generate();

    public GameController() {
        System.out.println(START_MESSAGE);
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
//        System.out.println(ComputerNumber);

        System.out.print(INPUT_MESSAGE);
        List<Integer> UserNumber = UserNumberInput.input();
//        System.out.println(UserNumber);

        String result = AnswerJudge.judge(UserNumber, ComputerNumber);
        System.out.println(result);
        if (AnswerJudge.isWin(result)) {
            return;
        }
        play();
    }

    private boolean isContinue() {
        System.out.println(CHOICE_MESSAGE);
        int choice = UserGameInput.choice();
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
