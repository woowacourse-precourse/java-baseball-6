package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        // 난수 생성 및 플레이어 입력 처리
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

        String result = app.defineStrikesOrBall(randomNumbers, playerNumbers);
    }

    // 스트라이크 & 볼 계산 로직
    public String defineStrikesOrBall(int[] randomNumbers, int[] playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == randomNumbers[i]) {
                strikes++;
            } else if (containsNumber(randomNumbers, playerNumbers[i])) {
                balls++;
            }
        }

        return String.format("%d스트라이크 %d볼", strikes, balls);
    }

    //
    private boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

}
