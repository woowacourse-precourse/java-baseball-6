package baseball;

import java.util.List;

public class Manager {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final OutputView outputView = new OutputView();
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private List<Integer> computerNumbers;

    public void setOneGame(){
        computerNumbers = computer.makeComputerNumbers();
        outputView.printStart();
    }

    public boolean manageGame(){
        while(true){
            List<Integer> userNumbers = setUserNumbers();
            if (isNotAnswer(userNumbers))
                continue;
            break;
        }
        return checkRestartChoice();
    }

    private List<Integer> setUserNumbers() {
        outputView.printInputMessage();
        String userInput = user.getUserInput();
        exceptionHandler.isInteger(userInput);
        exceptionHandler.isRightDigit(userInput);
        exceptionHandler.checkDuplicate(userInput);
        return user.getUserNumbers(userInput);
    }

    private boolean isNotAnswer(List<Integer> userNumbers) {
        List<Integer> strikeBall = resultGenerator.makeResult(userNumbers, computerNumbers);
        int strike = strikeBall.get(0);
        int ball = strikeBall.get(1);
        outputView.printResult(strike,ball);
        return strike != 3;
    }

    private boolean checkRestartChoice() {
        outputView.printEnd();
        String userInput= user.getUserInput();
        exceptionHandler.isInteger(userInput);
        int restartChoice = user.getRestartChoice(userInput);
        exceptionHandler.checkIsRightChoice(restartChoice);
        return restartChoice != 2;
    }
}
