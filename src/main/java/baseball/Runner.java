package baseball;

import baseball.game.GameManager;
import baseball.io.InputManager;
import baseball.io.OutputManager;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private InputManager inputManager = new InputManager();
    private OutputManager outputManager = new OutputManager();
    private GameManager gameManager = new GameManager();

    public Runner() throws IOException {
    }

    public void run() throws IOException {
        try {
            boolean restartGame = true;

            while(restartGame) {
                startGame();
                play();
                restartGame = isReStart();
            }
            Console.close();
        } catch (IllegalArgumentException e) {
            outputManager.printMessage("game.end.error");
            throw  e;
        }
    }

    public boolean isReStart() throws IOException {
        outputManager.printMessage("game.restart");
        String gameInput =  inputManager.readRestartInput();

        return gameManager.isReStart(gameInput);
    }

    public void play() throws IOException {
        boolean isAnswer = false;

        while(!isAnswer) {
            String gameInput = readGameInput();
            printHint(gameInput);
            isAnswer = isAnswer(gameInput);
        }

        outputManager.printMessage("game.end");
    }

    public void startGame() {
        outputManager.printMessage("game.start");
        gameManager.initGameAnswer();
    }

    public String readGameInput() throws IOException {
        outputManager.printMessage("game.input");
        String gameInput = inputManager.readGameInput();

        return gameInput;
    }

    public void printHint(String gameInput) {
        char[] hintArr = gameManager.generateHint(stringToList(gameInput));
        outputManager.printHint(hintArr);
    }

    public boolean isAnswer(String gameInput) {
        return gameManager.isAnswer(stringToList(gameInput));
    }

    public List<Integer> stringToList(String gameInput) {
        List<Integer> userInput = new ArrayList<>();

        for(char digit : gameInput.toCharArray()) {
            userInput.add(Character.getNumericValue(digit));
        }

        return userInput;
    }
}
