package baseball.controller;

import baseball.utility.Constant;
import baseball.utility.ExceptionHandler;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    private Output output = Output.getOutput();
    private Input input = Input.getInput();
    private int gameCount = 0;
    private List<Integer> computerNumber = new ArrayList<>();
    private GraderResult graderResult;
    private ExceptionHandler exceptionHandler = ExceptionHandler.getExceptionHandler();

    public GameStarter() {
        graderResult = new GraderResult();
    }

    public void announceStarter() {
        output.announceMention(Constant.GAME_START);

        boolean isContinuedUser = true;

        while (isContinuedUser) {
            isContinuedUser = checkNewbie();
        }
    }

    private boolean checkNewbie() {
        boolean isNewbie = gameCount == 0 ? true : false;
        boolean gamePlayer;

        if (isNewbie) {
            inputNumber();
            gamePlayer = true;
        } else {
            gamePlayer = askIntension();
        }

        gameCount++;

        return gamePlayer;
    }

    private void selectComputerNumber() {
        computerNumber.clear();
        int random;

        while (computerNumber.size() < 3) {
            random = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(random)) {
                computerNumber.add(random);
            }
        }
    }

    private boolean askIntension() {
        output.announceMention(Constant.ASK_RESTART);

        String intension = input.inputFromUser();
        boolean isPlayer = true;

        switch (intension) {
            case "1":
                inputNumber();
                break;
            case "2":
                output.announceMention(Constant.GAME_FINISH);
                isPlayer = false;
                break;
            default:
                throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.PROGRAM_END);
        }

        return isPlayer;
    }

    private void inputNumber(){
        selectComputerNumber();
        
        boolean isSolved = false;
        String inputValue;

        while (!isSolved) {
            output.announceMention(Constant.ANNOUNCE_INSERT_NUMBER);
            inputValue = input.inputFromUser();
            exceptionHandler.isSuitabledLength(inputValue);
            exceptionHandler.isNumber(inputValue);

            isSolved = judgeNumber(inputValue);
        }
    }

    private boolean judgeNumber(String inputNumber){
        String gameResult = graderResult.setGameResult(computerNumber, inputNumber);
        output.announceMention(gameResult);

        return isSolvedGame(gameResult);
    }

    private boolean isSolvedGame(String gameResult) {
        String endResult = String.format(Constant.STRIKE, 3);
        endResult = String.format("%s\n", endResult);
        boolean isThreeStrike = false;

        if (gameResult.equals(endResult)) {
            output.announceMention(Constant.CLEAR);
            output.announceMention(Constant.GAME_FINISH);
            isThreeStrike = true;
        }

        return isThreeStrike;
    }
}
