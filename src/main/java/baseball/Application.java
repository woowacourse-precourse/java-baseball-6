package baseball;

import baseball.controller.GameController;
import baseball.model.Command;
import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        User user = new User();
        Computer computer = new Computer();
        GameController gameController = new GameController();

        while (true) {
            user.inputNumber();
            String hint = gameController.getGameResult(user, computer);
            System.out.println(hint);
            String command = checkGameOver(hint);
            if (command.equals(Command.RESTART.getValue())) {
                computer = new Computer();
            }
            if (command.equals(Command.FINISH.getValue())) {
                break;
            }
        }
    }

    private static String checkGameOver(String hint) {
        if (hint.equals("3스트라이크")) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return Console.readLine();
        }
        return "";
    }
}
