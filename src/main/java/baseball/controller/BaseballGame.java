package baseball.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import baseball.constant.Constant;
import baseball.model.Computer;
import baseball.model.Counter;
import baseball.model.Player;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static BaseballGame baseballController = new BaseballGame();
    // View
    private OutputView outputView = new OutputView();
    private InputView inputView = outputView.getInputView();
    // Model
    private Computer computer = new Computer();
    private Player player = new Player();
    // Util
    private Validator validator = new Validator();
    private Counter counter = new Counter();

    private BaseballGame() {
    }

    public static BaseballGame getInstance() {
        return baseballController;
    }

    public void runGame() {
        outputView.printStartMessage();

        while (true) {
            play();
            if (quitGame())
                break;
        }
    }

    public void play() {
        computer.generateRandomNumbers();

        while (true) {
            this.counter = new Counter();

            outputView.printInputMessage();
            String playerInput = inputView.getInputLine();
            System.out.println(playerInput);
            if (!validator.gameInputVaildate(playerInput))
                throw new IllegalArgumentException();
            outputView.printInputMessage(playerInput);
            player.setNumbers(playerInput);

            compareNumbers(computer.getNumbers(), player.getNumbers());
            showResult();
            if (threeStrike()) {
                outputView.printGameEndMessage();
                break;
            }
        }
    }

    public void compareNumbers(List<Integer> computerNumbers, int[] playerNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers[i];
            
            if (computerNumber == playerNumber)
                counter.setStrikeCount(counter.getStrikeCount() + 1);
            else if (computerNumbers.contains(playerNumber))
                counter.setBallCount(counter.getBallCount() + 1);
        }
    }

    public void showResult() {
        String result = generateResultMessage();
        outputView.printResultMessage(result);
    }
    
    public String generateResultMessage() {
        int ballCount = counter.getBallCount();
        int strikeCount = counter.getStrikeCount();

        StringBuffer result = new StringBuffer();

        if (ballCount == 0 && strikeCount == 0)
            result.append("낫싱");
        if (ballCount != 0)
            result.append(ballCount + "볼 ");
        if (strikeCount != 0)
            result.append(strikeCount + "스트라이크");
        
        return result.toString().trim();
    }

    public Boolean threeStrike() {
        int strikeCount = counter.getStrikeCount();
        System.out.println(strikeCount);
        if (strikeCount == Constant.MAX_DIGIT) {
            return true;
        }
        return false;
    }

    public void showToBeContinue() {
        Map<String, String> map = new HashMap<>();
        map.put("continueInput", Constant.CONTINUE_INPUT);
        map.put("quitInput", Constant.QUIT_INPUT);
        outputView.printContinueOrQuitMessage(map);
    }

    public Boolean quitGame() {
        showToBeContinue();

        String input = inputView.getInputLine();
        if (!validator.quitInputValidate(input))
            throw new IllegalArgumentException();
        outputView.printInputMessage(input);

        if (input.equals(Constant.QUIT_INPUT)) {
            outputView.printQuitMessage();
            return true;    
        }

        return false;
    }
}
