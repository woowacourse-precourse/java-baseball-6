package baseball.handler;

import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.validator.InputValidator;
import baseball.view.OutputView;

import java.util.List;

public class GameHandler {
    private final UserInputHandler userInputHandler;
    private final ComputerNumberGenerator computerNumberGenerator;
    private final OutputView outputView;
    private final ResultGenerator resultGenerator;
    private final InputValidator inputValidator;
    private List<Integer> computerNumbers;

    public GameHandler(UserInputHandler userInputHandler, ComputerNumberGenerator computerNumberGenerator,
                       OutputView outputView, ResultGenerator resultGenerator,InputValidator inputValidator) {
        this.userInputHandler = userInputHandler;
        this.computerNumberGenerator = computerNumberGenerator;
        this.outputView = outputView;
        this.resultGenerator = resultGenerator;
        this.inputValidator = inputValidator;
    }

    public void initializeGameSession(){
        computerNumbers = computerNumberGenerator.makeUniqueNumbers();
        outputView.printStartMessage();
    }

    public boolean playGameSession(){
        while(true){
            if (playSingleRound())
                break;
        }
        return askForGameRestart();
    }

    private boolean playSingleRound(){
        List<Integer> userGuess = obtainValidUserGuess();
        return checkGuessResult(userGuess);
    }

    private boolean checkGuessResult(List<Integer> userNumbers) {
        List<Integer> strikeBall = resultGenerator.makeResult(userNumbers, computerNumbers);
        int strike = strikeBall.get(0); //TODO : strike, ball 객체로 빼기
        int ball = strikeBall.get(1);
        outputView.printResultMessage(strike,ball);
        return strike == 3;
    }

    private boolean askForGameRestart() {
        outputView.printEndMessage();
        outputView.printRestartMessage();
        int restartChoice = obtainValidUserChoice();
        return restartChoice != 2;
    }

    private List<Integer> obtainValidUserGuess(){
        outputView.printInputMessage();
        String userInput = userInputHandler.readInput();
        validateUserGuess(userInput);
        return userInputHandler.convertInputToNumbers(userInput);
    }

    private int obtainValidUserChoice() {
        String userInput= userInputHandler.readInput();
        validateUserChoice(userInput);
        return userInputHandler.parseRestartChoice(userInput);
    }

    private void validateUserChoice(String userInput) {
        inputValidator.validateIsInteger(userInput);
        inputValidator.validateChoice(userInput);
    }

    private void validateUserGuess(String userInput) {
        inputValidator.validateIsInteger(userInput);
        inputValidator.validateLength(userInput);
        inputValidator.validateNoDuplicate(userInput);
    }
}
