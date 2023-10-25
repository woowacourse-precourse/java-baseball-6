package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        String inputNumber;
        int[] inputNumber2Array = new int[3];
        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Randoms.pickNumberInRange(1, 9);
        }

        System.out.println("숫자 야구 게임을 시작합니다. ");
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for( int i = 0; i < 3; i++ ) {

            inputNumber2Array[i] = inputNumber.charAt(i) - '0';
        }

        System.out.println(Arrays.toString(randomNumber));
        System.out.println(Arrays.toString(inputNumber2Array));
    }
}

