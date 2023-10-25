package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        GameSupervisor gameSupervisor = new GameSupervisor();
        UserInputProccesor userInputProccesor = new UserInputProccesor(user, computer, gameSupervisor);

        ResultOperator resultOperator = new ResultOperator(userInputProccesor);

        InputValueValidator validator = new InputValueValidator();
        GameOperator gameOperator = new GameOperator(user, computer, validator, resultOperator, gameSupervisor);

        BaseballGame baseballGame = new BaseballGame(gameOperator);
        baseballGame.gameStart();
    }
}

