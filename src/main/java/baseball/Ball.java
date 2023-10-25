package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Ball {
    ArrayList<Integer> result = new ArrayList<>();

    public Ball() {
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) result.add(randomNumber);
        }
        for (Integer integer : result) System.out.println(integer.toString());
    }

    public static void start() {
        Ball ball;
        do {
            ball = new Ball();
            ball.gameStart();
        } while (ball.again());
    }

    public boolean again() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        if (number.equals("1")) return true;
        else if (number.equals("2")) return false;
        else throw new IllegalArgumentException();
    }

    public void gameStart() {
        String number;
        do {
            System.out.print("숫자를 입력해주세요 :");
            number = Console.readLine();
        } while (gameEndTest(number) != true);
    }

    public boolean gameEndTest(String number) {
        int strike = 0;
        int ballStrike = 0;
        int[] arr = numberToArray(number);

        for (int i = 0; i < result.size(); i++) if (arr[i] == result.get(i)) strike++;
        for (int i : arr) if (result.contains(i)) ballStrike++;

        showResult(strike, ballStrike);
        boolean result = (strike == 3) ? true : false;
        return result;
    }

    public void showResult(int strike, int ballStrike) {
        int ball = ballStrike - strike;
        if (ballStrike == 0) System.out.println("낫싱");
        else {
            if (ball != 0) System.out.print(ball + "볼 ");
            if (strike != 0) System.out.print(strike + "스트라이크 ");
        }
        if (strike == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public int[] numberToArray(String number) { //
        int[] arr = new int[3];

        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < 48 || number.charAt(i) > 57) {
                throw new IllegalArgumentException();
            }
            arr[i] = Integer.parseInt(number.substring(i, i + 1));
        }
        return arr;
    }
}
