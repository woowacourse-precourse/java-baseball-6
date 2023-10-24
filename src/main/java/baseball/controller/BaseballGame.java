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
    private final OutputView outputView;
    private final InputView inputView; 
    // Model
    private final Computer computer;
    private final Player player;
    private final Counter counter;
    // Util
    private final Validator validator;

    private BaseballGame() {
        this.outputView = new OutputView();
        this.inputView = outputView.getInputView();
        this.computer = new Computer();
        this.player = new Player();
        this.counter = new Counter();
        this.validator = new Validator();
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
            counter.init();
            outputView.printInputMessage();
            String playerInput = inputView.getInputLine();
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
        int strikeCount = 0;
        int ballCount = 0;
        
        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers[i];
            
            if (computerNumber == playerNumber)
                strikeCount++;
            else if (computerNumbers.contains(playerNumber))
                ballCount++;
        }
        
        counter.setStrikeCount(strikeCount);
        counter.setBallCount(ballCount);
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
