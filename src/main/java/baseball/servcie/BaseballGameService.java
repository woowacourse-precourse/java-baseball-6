package baseball.servcie;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.validation.BaseballGameValidation;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGameService {

    private final int NO_HIT = 0;
    private final int ALL_STRIKE = 3;
    private final String NEW_GAME = "1";
    private final BaseballGameValidation baseballGameValidation;
    private final User user;
    private final BaseballGameView baseballGameView;

    public BaseballGameService(User user, BaseballGameValidation baseballGameValidation, BaseballGameView baseballGameView) {
        this.baseballGameValidation = baseballGameValidation;
        this.user = user;
        this.baseballGameView = baseballGameView;
    }

    public void playGame(){
        Computer computer = new Computer();
        computer.initComputerBaseBallNumber();

        boolean check = false;

        while(!check) {
            baseballGameView.readNumPrint();
            List<Integer> userNumberList = userReadNumber(user);
            checkValidation(user, userNumberList);
            check = compareNumber(userNumberList, computer.getBaseballNumber());
        }
    }

    public boolean checkRestart(){
        String checkString = Console.readLine();

        baseballGameValidation.validateString(checkString);

        return (checkString.equals(NEW_GAME));

    }

    public boolean compareNumber(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = calculateStrike(userNumber, computerNumber);
        int ball = calculateBall(userNumber, computerNumber);

        printResult(strike, ball);

        return (strike == ALL_STRIKE);
    }

    private List<Integer> userReadNumber(User user) {
        user.readBaseballNumber();

        List<Integer> userNumberList = convertCharToInteger(user.getBaseballNumberList());
        return userNumberList;
    }

    private List<Integer> convertCharToInteger(String baseBallString) {
        List<Integer> baseballNumbers = new ArrayList<>();

        for (char baseballChar : baseBallString.toCharArray())
            if (baseballGameValidation.checkDigit(baseballChar))
                baseballNumbers.add(Character.getNumericValue(baseballChar));

        return baseballNumbers;
    }

    public void checkValidation(User user, List<Integer> baseballNumbers){
        baseballGameValidation.validateBaseballNumber(user.getBaseballNumberList());
        baseballGameValidation.checkBaseballNumberSize(baseballNumbers);
    }

    private static int calculateStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) IntStream.range(0, computerNumber.size())
                .filter(index -> computerNumber.get(index).equals(userNumber.get(index)))
                .count();
    }

    private static int calculateBall(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) IntStream.range(0, computerNumber.size())
                .filter(index -> computerNumber.contains(userNumber.get(index))
                        && !computerNumber.get(index).equals(userNumber.get(index)))
                .count();
    }

    private void printResult(int strike, int ball) {
        if (strike == NO_HIT && ball == NO_HIT)
            baseballGameView.nothingResultPrint();

        if (ball > NO_HIT)
            baseballGameView.ballResultPrint(ball);

        if (strike > NO_HIT)
            baseballGameView.strikeResultPrint(strike);

        System.out.println();
    }

}
