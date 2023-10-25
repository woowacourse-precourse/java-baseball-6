package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        InputValueValidator validator = new InputValueValidator();
        GameSupervisor gameSupervisor = new GameSupervisor();
        GameController gameController = new GameController(user, computer, gameSupervisor);

        BaseballGame baseballGame = new BaseballGame(user, computer, validator, gameController, gameSupervisor);

        baseballGame.gameStart();
    }
}

