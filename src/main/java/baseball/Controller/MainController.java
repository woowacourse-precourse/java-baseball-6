package baseball.Controller;

import baseball.Model.GameData;
import baseball.View.InputView;
import baseball.View.OutputView;

public class MainController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    GameData gameData = new GameData();
    RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
    PlayerInputController playerInputController = new PlayerInputController();
    Comparator comparator = new Comparator();
    Validator validator = new Validator();

    private static int state = 1;
    private static int count = 0;
    public MainController() {
        state = 1;
        count = 0;
    }

    public void playGame(){
        outputView.printGameStart();
        while (state == 1){
            if(count == 0){
                gameData.setComputerNumber(randomNumbersGenerator.generateNumbers());
            }
            processInputAndCompare();
        }
    }

    private void processInputAndCompare() {
        while (true) {
            //processPlayerInput();
            if (comparator.isEndGame(gameData.getComputerNumber(), gameData.getPlayerInput())){
                //checkReplay();
                return;
            }
            //processComperater();
        }
    }

}
