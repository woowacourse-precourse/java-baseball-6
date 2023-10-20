package baseball;

import java.util.List;

public class Manager {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final OutputView outputView = new OutputView();
    private final ResultMaker resultMaker = new ResultMaker();
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private List<Integer> computerNumbers;

    public void setOneGame(){
        computerNumbers = computer.makeThreeDigitNum();
        outputView.printStart();
    }
    public boolean manageGame(){
        while(true){
            outputView.printInputMessage();
            String userInput = user.getUserInput();
            exceptionHandler.checkIsInteger(userInput);
            exceptionHandler.checkRightDigit(userInput);
            exceptionHandler.checkDuplicate(userInput);
            List<Integer> userNumbers = user.getNumbers(userInput);
            List<Integer> strikeBall = resultMaker.makeResult(userNumbers, computerNumbers);
            int strike = strikeBall.get(0);
            int ball = strikeBall.get(1);
            outputView.printResult(strike,ball);
            if (strike!=3){
                continue;
            }
            break;
        }
        outputView.printEnd();
        String userInput=user.getUserInput();
        exceptionHandler.checkIsInteger(userInput);
        int restartChoice = user.getRestartChoice(userInput);
        exceptionHandler.checkIsRightChoice(restartChoice);
        return restartChoice != 2;
    }

}
