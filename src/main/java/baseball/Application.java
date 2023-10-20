package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int[] playerNumbers = new int[3];
        int[] randomNumbers = new int[3];

        //: 3개의 난수 생성(COM)
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers[i] = randomNumber;
        }

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("1 ~ 9 사이의 숫자를 입력하세요");
            int playerNumber = scan.nextInt();
            playerNumbers[i] = playerNumber;
        }
    }
}
