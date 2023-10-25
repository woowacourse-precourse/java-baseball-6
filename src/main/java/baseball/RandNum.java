package baseball;

import static baseball.Application.COUNT_3;

import camp.nextstep.edu.missionutils.Randoms;

public class RandNum {

    public static String Make_Random_Num() {
        int cnt = 0;
        int result = 0;
        int[] check = new int[10];

        while (cnt < COUNT_3) {

            int temp = Randoms.pickNumberInRange(1, 9);

            if (check[temp] == 0) {
                result *= 10;
                result += temp;
                cnt++;
            }
        }

        return Integer.toString(result);
    }
}
