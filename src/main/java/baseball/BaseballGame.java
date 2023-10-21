package baseball;


import baseball.logic.GameManage;
import baseball.logic.InputValidator;
import java.util.List;

public class BaseballGame {
    private final Computer computer = new Computer();

    private final User user = new User();

    private final InputValidator validator = new InputValidator();

    private final GameManage gameManage = new GameManage();

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        int command = 1;
        List<Integer> answerNumbers = computer.makeNumbers();

        while (command == 1) {
            gameManage.init();
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = user.inputNumbers();
            List<Integer> userNumbers = validator.validateInput(userInput);

            gameManage.getResult(answerNumbers, userNumbers);
            gameManage.showResult();
            if (gameManage.getStrikeCount() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                command = user.commandInput();

                if (command == 1) {
                    answerNumbers = computer.makeNumbers();
                }
            }
        }
    }
}
