package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.model.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final Computer computer;
    private final Player player;
    private final Hint hint;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.computer = new Computer();
        this.player = new Player();
        this.hint = new Hint();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

//    public void gameStart() {
//        boolean progress = true;
//
////        printStartMessage();
//
//        while(progress) {
//            progress();
//
////            progress = isRestart();
//        }
//    }

//    private void progress() {
//        boolean isCorrect = false;
//        List<Integer> computerNumbers = computer.getNumbers();
//        List<Integer> playerNumbers;
//
//        while(!isCorrect) {
//            playerNumbers = getPlayerNumber();
//            isCorrect = compareNumber(computerNumbers, playerNumbers);
//        }
//
//        printEndMessage();
//    }


}
