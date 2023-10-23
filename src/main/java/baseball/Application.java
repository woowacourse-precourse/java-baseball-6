package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void createRandom(List<Integer> computerNumber) {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
    public static void inputUser(List<Integer> userNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());

        if (input > 999 || input < 100) {
            throw new IllegalArgumentException("Invalid argument: " + input);
             // 입력 받은 값이 100 ~ 999의 정수가 아님
        }
        userNumber.add(input / 100);
        userNumber.add((input - input % 10) / 10 % 10);
        userNumber.add(input % 10);
    }
    public static int[] calcStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int[] countWeight = new int[] {0, 0};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumber.get(i).equals(computerNumber.get(j))) {
                    if (i == j) {
                        countWeight[0]++;
                    } else {
                        countWeight[1]++;
                    }
                }
            }
        }
        return countWeight;
    }
    public static boolean checkAnswer(int strikeCount, int ballCount, int[] countWeight) {
        strikeCount += countWeight[0];
        ballCount += countWeight[1];

        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println(strikeCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
        return false;
    }
    public static boolean endGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String menuNumber = Console.readLine();

        if (menuNumber.equals("1")) {
            return true;
        } else if (menuNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid argument: " + menuNumber);
             // 입력 받은 값이 1이나 2가 아님
        }
    }
    public static void numberGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");

        boolean gameState = true;
        while (gameState) {
            int strikeCount = 0;
            int ballCount = 0;
            List<Integer> computerNumber = new ArrayList<>();

            createRandom(computerNumber);

            boolean isAnswerCorrect = false;
            while (!isAnswerCorrect) {
                List<Integer> userNumber = new ArrayList<>();

                inputUser(userNumber);

                int[] countWeight = calcStrike(userNumber, computerNumber);
                isAnswerCorrect = checkAnswer(strikeCount, ballCount, countWeight);
            }
            gameState = endGame();
        }
    }
    public static void main(String[] args) {
        numberGame();
    }
}