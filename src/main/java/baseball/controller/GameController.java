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
                input.add(inputString.charAt(i) - '0');
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

        if(input.charAt(0) == '1') {
            gameProceed();
        }
    }

    private void getRandomNumber() {
        computer.clear();
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
            if(computer.contains(input.get(i))) {
                ballCount += 1;
            }

            if(computer.get(i) == input.get(i)) {
                strikeCount += 1;
            }
        }
        ballCount = ballCount - strikeCount;

        return new GameResult(ballCount, strikeCount);
    }

    private void validateBaseballInput(String input) {
        List<Character> validations = new ArrayList<>();

        if(input.length() != 3) {
            ExceptionHandler.inputException();
        }

        for(int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                ExceptionHandler.inputException();
            }

            if(validations.contains(input.charAt(i))) {
                ExceptionHandler.inputException();
            }

            validations.add(input.charAt(i));
        }
    }

    private void validateExitInput(String input) {
        if(input.length() != 1) {
            ExceptionHandler.inputException();
        }

        if(input.charAt(0) != '1' && input.charAt(0) != '2') {
            ExceptionHandler.inputException();
        }
    }
}
