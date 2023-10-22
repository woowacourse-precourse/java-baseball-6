package baseball;

import java.util.List;

public class GameSession {
    private final User user = new User();
    private final Computer gameSession = new Computer();
    private final OutputView outputView = new OutputView();
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private final InputValidator inputValidator = new InputValidator();
    private List<Integer> computerNumbers;

    public void initializeGameSession(){
        computerNumbers = gameSession.makeComputerNumbers();
        outputView.printStart();
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
        outputView.printResult(strike,ball);
        return strike == 3;
    }

    private boolean askForGameRestart() {
        int restartChoice = obtainValidUserChoice();
        return restartChoice != 2;
    }

    private List<Integer> obtainValidUserGuess(){
        while(true){
            try{
                outputView.printInputMessage();
                String userInput = user.getUserInput();
                validateUserGuess(userInput);
                return user.getUserNumbers(userInput);
            }catch (IllegalArgumentException e){
                //print error message
                //TODO : 에러 메세지 view 만들기
            }
        }
    }

    private int obtainValidUserChoice() {
        while(true){
            try{
                outputView.printEnd();
                String userInput= user.getUserInput();
                validateUserChoice(userInput);
                return user.getRestartChoice(userInput);
            }catch (IllegalArgumentException e){
                //print error message
                //TODO : 에러 메세지 view 만들기
            }
        }
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
