package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {

    static List<Integer> randomNum;

    public static void main(String[] args) {
        startGame();
        String userNum = "";
        int[] user = new int[10];
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNum = readLine();

            checkNum(userNum);
            user = toArr(userNum);

            int strikeCount = strike(userNum, user, randomNum);
            int ballCount = ball(user, randomNum);
            
            printCount(strikeCount, ballCount);
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userNum = readLine();
                if (Integer.parseInt(userNum) == 2) {
                    return;
                }
                startGame();
            }

        }

    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumber();
    }

    private static void randomNumber() {
        randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(num)) {
                randomNum.add(num);
            }
        }
    }

    private static int strike(String num, int[] arr, List<Integer> randomNum) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (num.charAt(i) - '0' == randomNum.get(i)) {
                count++;
                arr[randomNum.get(i)]--;
            }
        }
        return count;
    }

    private static int ball(int[] num, List<Integer> randomNum) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (num[randomNum.get(i)] > 0) {
                count++;
                num[randomNum.get(i)]--;
            }
        }
        return count;
    }

    private static void checkNum(String num) throws IllegalArgumentException {
        if (num.length() != 3) {
            throw new IllegalArgumentException();
        }
        int[] check = new int[10];
        for (int i = 0; i < 3; i++) {
            int n = num.charAt(i) - '0';
            check[n]++;
            if (check[n] > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int[] toArr(String num) {
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0']++;
        }
        return arr;
    }

    private static void printCount(int strikeCount, int ballCount) {

        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }

        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }

        if (ballCount > 0) {
            System.out.println(ballCount + "볼");
            return;
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }

    }
}
