package baseball.factory;

import baseball.checker.InputValueChecker;
import camp.nextstep.edu.missionutils.Randoms;

// 숫자 야구 게임에서 활용할 임의의 값을 생성하는 클래스
public class NumberFactory {
    private final static int LENGTH_LIMIT = 3;

    // 사용자가 맞추어야하는 임의의 값을 생성하는 메서드, 중복되는 숫자가 존재하는 경우 재생성
    public static String getRandomNumber() {
        String randomNumber = generateRandomNumber();

        while(!InputValueChecker.checkDuplication(randomNumber)) {
            randomNumber = generateRandomNumber();
        }

        return randomNumber;
    }

    // 임의의 값 생성
    private static String generateRandomNumber() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < LENGTH_LIMIT; i++) {
            sb.append(Randoms.pickNumberInRange(0, 9));
        }

        return sb.toString();
    }

    private NumberFactory() {
    }
}