package baseball.controllers;

import baseball.model.CalculateNumber;
import baseball.views.InputView;
import baseball.model.UserNumber;
import baseball.utils.Validator;
import baseball.views.OutputView;

public class GameController {
    private final CalculateNumber calNum;
    private static UserNumber user;
    private final Validator validator;

    public GameController() {
        calNum = new CalculateNumber();
        validator = new Validator();
    }

    public void start() {
        do {
            getNumberFromUser();
            printCount(getCompareNumber());
        } while (!isGameSet());

    }

    public void getNumberFromUser() {
        user = new UserNumber(InputView.setUserNumber());
        user.getUserNumber();
    }

    public int[] getCompareNumber() {

        return validator.getCompareNumber(user.getUserNumber(), calNum.getCalculateNumber());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count) {
        if (count[0] != 0) {
            if(count[1] !=0){
                OutputView.printCount(count[0]);
                OutputView.printBallStrikeMessage();;
            }else{
                OutputView.printCount(count[0]);
                OutputView.printBallMessage();
            }

        }
    }

    public static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothingMessage();
        }
    }


    public boolean isGameSet() {
        if (validator.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }
}
