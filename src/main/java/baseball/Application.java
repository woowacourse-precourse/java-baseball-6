package baseball;

import baseball.controller.GameController;
import baseball.model.NumberComparator;
import baseball.model.ProgramNumber;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        NumberComparator numberComparator = new NumberComparator();
        ProgramNumber programNumber = new ProgramNumber();
        GameController gameController = new GameController(numberComparator, programNumber);
        
        gameController.startGame();
    }
}
