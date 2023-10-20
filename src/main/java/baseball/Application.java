package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int[] playerNumbers = new int[3];
        int[] randomNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers[i] = randomNumber;
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("1 ~ 9 사이의 숫자를 입력하세요");
            int playerNumber = Integer.parseInt(Console.readLine());
            playerNumbers[i] = playerNumber;
        }
    }
}
