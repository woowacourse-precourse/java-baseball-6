package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static final int BALLS_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    /**
     * 랜덤 볼 3개 만들기
     */
    public List<Integer> makeRandomBalls() {

        List<Integer> randomBalls = new ArrayList<>();

        while (randomBalls.size() < BALLS_SIZE) {
            int randomBall = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(randomBall)) {
                randomBalls.add(randomBall);
            }
        }

        return randomBalls;
    }

    /**
     * 사용자에게 3개 숫자 입력받기
     */
    public List<Integer> inputUserBalls() {

        List<Integer> userBalls = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        //TODO: 입력값 유효성 확인 로직 필요
        for (char c : userInput.toCharArray()) {
            userBalls.add(Character.getNumericValue(c));
        }

        return userBalls;
    }
}
