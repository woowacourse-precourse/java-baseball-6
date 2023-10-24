package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;

public class GameService {

    private static Computer computer;
    private static User user;

    private static Game game;
    public GameService() {
        computer = new Computer();
        user = new User();
        game = new Game();
    }

    public void executeGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
        do {
            user.inputUserNumber();
            game.compare(computer.getComputerNumbers(), user.getUserNumber());
            game.printCompareResult();
        }while(game.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
