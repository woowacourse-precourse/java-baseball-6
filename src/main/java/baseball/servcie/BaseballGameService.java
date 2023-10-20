package baseball.servcie;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGameService {

    private final int NO_HIT = 0;
    private final int ALL_STRIKE = 3;

    public void checkRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkString = Console.readLine();

        if (!Arrays.asList("1", "2").contains(checkString))
            throw new IllegalArgumentException();

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

    private static List<Integer> userReadNumber() {
        User user = new User();
        user.readBaseballNumber();
        user.validateBaseballNumber(user.getBaseballNumberList());
        List<Integer> userNumberList = user.convertCharToInteger(user.getBaseballNumberList());
        return userNumberList;
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
            System.out.println("낫싱");

        if (ball > NO_HIT)
            System.out.println(ball + "볼 ");

        if (strike > NO_HIT)
            System.out.println(strike + "스트라이크 ");

        if (strike == ALL_STRIKE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
