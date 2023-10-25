package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        System.out.println("숫자 야구 게임을 시작합니다. ");
        System.out.print("숫자를 입력해주세요 : ");
        System.out.println(Console.readLine());

        System.out.println(Arrays.toString(randomNumber));
    }
}

