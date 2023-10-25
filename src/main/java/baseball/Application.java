package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public static void main(String[] args) {
        playBaseballGame();
    }

    public static void playBaseballGame() {
        Console console = new Console();
        Randoms randoms = new Randoms();


        while (true) {
            int[] computerNumbers = randoms.pickNumberInRange(1, 9, 3);
            console.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                int userGuess = console.readInt("서로 다른 3개의 숫자를 입력하세요: ");
                int[] result = checkGuess(userGuess, computerNumbers);
                printGuessResult(result, console);

                if (result[0] == 3) {
                    console.println("3개의 숫자를 모두 맞히셨습니다. 축하합니다!");
                    break;
                }

                if (result[0] == 0 && result[1] == 0) {
                    console.println("낫싱");
                }
            }

            String restartChoice = console.readLine("게임을 다시 시작하려면 '1', 완전히 종료하려면 '2'를 입력하세요: ");
            if ("2".equals(restartChoice)) {
                console.println("게임을 종료합니다.");
                return; // 종료
            }
        }
    }

    public static int[] generateComputerNumbers(Randoms randoms) {
        return randoms.pickNumberInRange(1, 9, 3);
    }

    public static int getUserInput(Console console) {
        int userGuess = console.readInt("서로 다른 3개의 숫자를 입력하세요: ");
        if (!isValidInput(userGuess)) {
            throw new IllegalArgumentException("1에서 9 사이의 서로 다른 숫자 3개를 입력하세요.");
        }
        return userGuess;
    }

    public static boolean isValidInput(int guess) {
        if (guess < 100 || guess > 999) {
            return false;
        }

        int digit1 = guess / 100;
        int digit2 = (guess / 10) % 10;
        int digit3 = guess % 10;

        return digit1 != digit2 && digit2 != digit3 && digit1 != digit3;
    }

    public static int[] checkGuess(int guess, int[] target) {
        int[] result = new int[2];

        int[] guessDigits = new int[3];
        guessDigits[0] = guess / 100;
        guessDigits[1] = (guess / 10) % 10;
        guessDigits[2] = guess % 10;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guessDigits[i] == target[j]) {
                    if (i == j) {
                        result[0]++; // 스트라이크
                    } else {
                        result[1]++; // 볼
                    }
                }
            }
        }

        return result;
    }

    public static void printGuessResult(int[] result, Console console) {
        if (result[0] == 0 && result[1] == 0) {
            console.println("낫싱");
        } else {
            console.println(result[0] + " 스트라이크, " + result[1] + " 볼");
        }
    }
}
