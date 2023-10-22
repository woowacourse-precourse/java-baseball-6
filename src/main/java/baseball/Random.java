import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

private static final int MIN=1;
private static final int MAX=9;

public class Random {

        // 중복되지 않는 3개의 숫자를 생성
        public static HashSet createRandomNumber() {
                HashSet<Integer> randomNumbers = new HashSet<>(3);
                while (randomNumbers.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
                        randomNumbers.add(randomNumber);
                }
                return randomNumbers;
        }

        // HashSet을 String으로 변환하여 반환
        public static String returnRandomNumber() {
                HashSet<Integer> randomNumbers = createRandomNumber();
                Iterator iter = randomNumbers.iterator(); // Iterator를 사용하여 HashSet의 요소를 출력
                String result = "";

                while (iter.hasNext()) {
                        result += iter.next();
                }
                return result;

        }
}