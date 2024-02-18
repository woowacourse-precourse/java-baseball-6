package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class CreatingRandomNumber {
    public static int[] RandomNumber() {
        int[] number = new int[3];

        for (int i = 0; i < 3; i++) {
            number[i] = Randoms.pickNumberInRange(1, 9);

            // 중복 제거
            for (int j = 0; j < i; j++) {
                if (number[i] == number[j]) {
                    i--;
                    break;
                }
            }
        }

        return number;
    }
}
