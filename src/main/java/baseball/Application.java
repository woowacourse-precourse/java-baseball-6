package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        String com_num = "";
        for(int i = 0; i < 3; i++) {
            int randomDigit = (int)(Randoms.pickNumberInRange(1, 9)); // 0에서 9까지의 난수를 얻음
            com_num = String.valueOf(randomDigit);
        }
        System.out.println(com_num);
    }
}
