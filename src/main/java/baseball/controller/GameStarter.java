package baseball.controller;

import baseball.model.NumberVO;
import baseball.utility.Constant;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    private Output output = Output.getOutput();
    private Input input = Input.getInput();
    private int gameCount = 0;
    private NumberVO numberVO;
    private GraderResult graderResult;

    public GameStarter() {
        graderResult = new GraderResult();
    }

    public void announceStarter() throws IOException {
        output.announceMention(Constant.GAME_START);

        boolean isContinuedUser = true;

        while (isContinuedUser) {
            isContinuedUser = checkNewbie();
        }
    }

    private boolean checkNewbie() throws IOException {
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
        List<Integer> computerNumber = new ArrayList<>();
        int random;

        while (computerNumber.size() < 3) {
            random = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(random)) {
                computerNumber.add(random);
            }
        }

        numberVO = new NumberVO(computerNumber);
    }

    private boolean askIntension() throws IOException {
        output.announceMention(Constant.ASK_RESTART);

        int intension = input.inputFromUser();
        boolean isPlayer = true;

        switch (intension) {
            case 1:
                inputNumber();
                break;
            case 2:
                output.announceMention(Constant.GAME_FINISH);
                isPlayer = false;
                break;
            default:
                throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.PROGRAM_END);
        }

        return isPlayer;
    }

    private void inputNumber() throws IOException {
        selectComputerNumber();

        boolean isSolved = false;
        String gameResult;
        int inputValue;

        while (!isSolved) {
            output.announceMention(Constant.ANNOUNCE_INSERT_NUMBER);
            inputValue = input.inputFromUser();

            gameResult = graderResult.setGameResult(numberVO, inputValue);

            output.announceMention(gameResult);

            isSolved = isSolvedGame(gameResult);
        }
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
