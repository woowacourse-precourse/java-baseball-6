package baseball;

public class ResultOperator {
    private final UserInputProccesor userInputProccesor;

    public ResultOperator(UserInputProccesor userInputProccesor) {
        this.userInputProccesor = userInputProccesor;
    }
    public String evaluateUserNum(String userNum) {
        return userInputProccesor.processUserInput(userNum);
    }
}
