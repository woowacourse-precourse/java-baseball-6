package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static int pick1DigitRandomNumber() {
        return pickNumberInRange(1, 9);
    }

    public static NumberSet pickRandomUniqueNumberSet() {
        NumberSet result;
        do {
            result = new NumberSet(
                    pick1DigitRandomNumber(),
                    pick1DigitRandomNumber(),
                    pick1DigitRandomNumber()
            );
        } while (!result.isUnique());
        return result;
    }

    public static void playGame(NumberSet answer) {
        int strikes;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            NumberSet input = readAnswer();
            GuessResult result = new GuessResult(input, answer);
            printResult(result);
            strikes = result.getStrikes();
        } while (strikes != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static NumberSet readAnswer() {
        String string = readLine();
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return new NumberSet(number);
    }

    public static void printResult(GuessResult result) {
        int strikes = result.getStrikes();
        int balls = result.getBalls();

        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
        } else {
            if (balls > 0)
                System.out.printf("%d볼", balls);
            if (balls > 0 && strikes > 0) System.out.print(" ");
            if (strikes > 0)
                System.out.printf("%d스트라이크", strikes);
            System.out.println();
        }
    }

    public static boolean retry() throws IllegalArgumentException {
        int answer;
        try {
            answer = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (answer != 1 && answer != 2)
            throw new IllegalArgumentException();
        return answer == 1;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            NumberSet answer = pickRandomUniqueNumberSet();
            playGame(answer);
        } while (retry());
    }
}
