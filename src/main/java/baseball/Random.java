package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Iterator;

import static baseball.Stationary.*;

public class Random {

        // 중복되지 않는 3개의 숫자를 생성
        public static HashSet<Integer> createRandomNumber() {
                HashSet<Integer> randomNumbers = new HashSet<>();
                while (randomNumbers.size() < INPUT_LENGTH) {
                        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
                        randomNumbers.add(randomNumber);
                }
                return randomNumbers;
        }

        // HashSet을 String으로 변환하여 반환
        public static String returnRandomNumber() {
                HashSet<Integer> randomNumbers = createRandomNumber();
                Iterator<Integer> iter = randomNumbers.iterator(); // Iterator를 사용하여 HashSet의 요소를 출력
                StringBuilder result = new StringBuilder();

                while (iter.hasNext()) {
                        result.append(iter.next());
                }

                return result.toString();
        }
}