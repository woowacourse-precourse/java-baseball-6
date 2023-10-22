package baseball;

import java.util.List;

public class GameHandler {
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final ComputerNumberGenerator gameSession = new ComputerNumberGenerator();
    private final OutputView outputView = new OutputView();
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private final InputValidator inputValidator = new InputValidator();
    private List<Integer> computerNumbers;

    public void initializeGameSession(){
        computerNumbers = gameSession.makeUniqueNumbers();
        outputView.printStartMessage();
    }

    public boolean playGameSession(){
        while(!playSingleRound()){
            //게임 성공 -> 종료
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
        outputView.printEndMessage();
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
