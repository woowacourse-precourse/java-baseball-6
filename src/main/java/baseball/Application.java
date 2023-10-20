package baseball;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String numberStr = RandomNumberGenerator();
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame(numberStr);
    }

    public static void playGame(String numberStr) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String N = sc.nextLine();
            int strikes = countStrikes(numberStr, N);
            int balls = countBalls(numberStr, N);
            printInfo(strikes, balls);
            if (strikes == 3) break;
        }
        restartGame();
    }

    public static String RandomNumberGenerator() {
        int min = 100;
        int max = 999;
        int randomNumber = Randoms.pickNumberInRange(min, max);
        String numberStr = String.valueOf(randomNumber);
        return numberStr;
    }

    public static int countStrikes(String key, String guess_num) {
        int strikes = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == guess_num.charAt(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    public static int countBalls(String key, String guess_num) {
        int balls = 0;
        for (int i = 0; i < key.length(); i++) {
            char targetDigit = guess_num.charAt(i);
            if (targetDigit != key.charAt(i) && key.contains(String.valueOf(targetDigit))) {
                balls++;
            }
        }
        return balls;
    }

    public static void printInfo(int strikes, int balls) {
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크 ");
        }
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println();
        }
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }
    }

    public static void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int game = sc.nextInt();
        if (game == 1) {
            String ran_Num = RandomNumberGenerator();
            playGame(ran_Num);
        }
    }
}

