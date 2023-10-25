package Controller;

import Player.Computer;
import Player.User;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final User user;
    private final Computer computer;

    public GameController(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public void startGame() {
        boolean gameContinues;
        do {
            gameContinues = playGame();
        } while (gameContinues);
    }

    private boolean playGame() {
        System.out.println("숫자 아구 게임을 시작합니다.");
        computer.setAnswer();
        while (true) {
            System.out.println("숫자를 입력해주세요.");
            user.setAnswer();

            if (computer.compareAnswer(user.getAnswer())) {
                return checkRetry();
            }
        }
    }

    private boolean checkRetry() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userReply = Console.readLine();
        Validator.checkValidOfReply(userReply);
        return userReply.equals("1");
    }
}
