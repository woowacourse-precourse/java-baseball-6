package baseball.controller;

import baseball.model.GameResult;
import baseball.util.ExceptionHandler;
import baseball.view.InputView;
import baseball.view.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private InputView inputView;
    private OutputView outputView;
    List<Integer> computer = new ArrayList<>();

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void gameStart() {
        getRandomNumber();
        outputView.showStart();

        gameProceed();
    }

    private void gameProceed() {
        String inputString;
        List<Integer> input = new ArrayList<>();
        GameResult result;

        while(true) {
            inputString = inputView.getBaseballNumber();
            validateBaseballInput(inputString);

            input.clear();
            for(int i = 0; i < inputString.length(); i++) {
                input.add(inputString.indexOf(i) - '0');
            }

            result = getGameResult(input);
            outputView.showResult(result);

            if(result.isStrikeOut()) {
                break;
            }
        }
        gameEnd();
    }

    private void gameEnd() {
        String input;

        outputView.showEnd();

        input = inputView.getExit();
        validateExitInput(input);

        if(input == "1") {
            gameProceed();
        }
    }

    private void getRandomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private GameResult getGameResult(List<Integer> input) {
        int ballCount, strikeCount;

        ballCount = 0;
        strikeCount = 0;
        for(int i = 0; i < input.size(); i++) {
            if(computer.contains(input.indexOf(i))) {
                ballCount += 1;
            }

            if(computer.indexOf(i) == input.indexOf(i)) {
                strikeCount += 1;
            }
        }
        ballCount = ballCount - strikeCount;

        return new GameResult(strikeCount, ballCount);
    }

    private void validateBaseballInput(String input) {
        List<Integer> validations = new ArrayList<>();

        if(input.length() != 3) {
            ExceptionHandler.inputException();
        }

        for(int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.indexOf(i))) {
                ExceptionHandler.inputException();
            }

            if(validations.contains(input.indexOf(i))) {
                ExceptionHandler.inputException();
            }

            validations.add(input.indexOf(i) - '0');
        }
    }

    private void validateExitInput(String input) {
        if(input != "1" && input != "2") {
            ExceptionHandler.inputException();
        }
    }
}
