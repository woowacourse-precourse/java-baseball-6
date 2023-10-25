package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtil {

    public static List<Integer> makeRandomNumbers() {

        // 컴퓨터 랜덤숫자 만들기
        Set<Integer> sortedNumbers = new HashSet<>();

        // 1 ~ 9까지 중복되지 않게 3자리 랜덤숫자 정하기
        while (sortedNumbers.size() < 3) {
            sortedNumbers.add(Randoms.pickNumberInRange(1, 9));
        }

        // Set -> List로 변환
        List<Integer> randomNumbers = new ArrayList<>(sortedNumbers);

        // 3자리 숫자 섞기
        randomNumbers = Randoms.shuffle(randomNumbers);

        return randomNumbers;
    }

    public static void printResult(int ball, int strike) {
        if (strike > 0 && strike < 3 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && strike < 3) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    public static boolean isEnd(int ball, int strike) {
        return strike == 3;
    }
}
