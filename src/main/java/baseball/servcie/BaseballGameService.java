package baseball.servcie;

import baseball.domain.User;
import baseball.validation.BaseballGameValidation;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class BaseballGameService {

    private final int NO_HIT = 0;
    private final int ALL_STRIKE = 3;
    private final BaseballGameValidation baseballGameValidation;

    public BaseballGameService() {
        this.baseballGameValidation = new BaseballGameValidation();
    }

    public void playGame(){
        List<Integer> computerBaseBallNumber = initComputerBaseBallNumber();

        boolean check = false;

        while(!check) {
            List<Integer> userNumberList = userReadNumber();

            check = compareNumber(userNumberList, computerBaseBallNumber);
        }

    }

    public void checkRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkString = Console.readLine();

        baseballGameValidation.validateString(checkString);

        if(checkString.equals("1"))
            playGame();
    }

    public List<Integer> initComputerBaseBallNumber() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }

    public boolean compareNumber(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = calculateStrike(userNumber, computerNumber);
        int ball = calculateBall(userNumber, computerNumber);

        printResult(strike, ball);

        return (strike == ALL_STRIKE);
    }

    public List<Integer> userReadNumber() {
        User user = new User();
        user.readBaseballNumber();
        baseballGameValidation.validateBaseballNumber(user.getBaseballNumberList());

        List<Integer> userNumberList = convertCharToInteger(user.getBaseballNumberList());
        return userNumberList;
    }

    public List<Integer> convertCharToInteger(String baseBallString) {
        ArrayList<Integer> baseballNumbers = new ArrayList<>();

        for (char baseballChar : baseBallString.toCharArray())
            if (Character.isDigit(baseballChar) && Character.getNumericValue(baseballChar) != 0)
                baseballNumbers.add(Character.getNumericValue(baseballChar));

        baseballGameValidation.checkBaseballNumberSize(baseballNumbers);

        return baseballNumbers;
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
            System.out.print("낫싱");

        if (ball > NO_HIT)
            System.out.print(ball + "볼 ");

        if (strike > NO_HIT)
            System.out.print(strike + "스트라이크 ");

        if (strike == ALL_STRIKE) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println();
    }

}
