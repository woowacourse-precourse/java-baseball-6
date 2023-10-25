package baseball.controller;
import static baseball.util.ConstantUtil.START_MESSAGE;
import static baseball.util.ConstantUtil.SUCCESS_MATCH_NUMBER;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballController {
    ExceptionController exceptionController = new ExceptionController();

    public void runGame() {

        boolean state = true;

        System.out.println(START_MESSAGE);

        while(state) {
            GameController gameController = new GameController();
            gameController.matchNumber();
            System.out.println(SUCCESS_MATCH_NUMBER);
            state = isEndGame();
        }
    }

    private boolean isEndGame() {
        String input = readLine();
        exceptionController.validateInputOneOrTwo(input);
        if(input.equals("2")){
            return false;
        }
        return true;
    }

}
