package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private static int answer;

    private BaseballGame() {
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            answer = makeRandomAnswer();

            while (true) {
                int userAnswer;
                userAnswer = getUserAnswer();

                if (checkUserAnswer(userAnswer))
                    break;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            if (reGame()) {
                break;
            }
        }
    }

    private static int getUserAnswer() {
        int userAnswer;

        System.out.print("숫자를 입력해주세요 : ");

        try {
            userAnswer = Integer.parseInt(Console.readLine());
            if (!(userAnswer >= 100 && userAnswer < 1000))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            // exception test
            throw new IllegalArgumentException();
        }

        return userAnswer;
    }

    private static int makeRandomAnswer() {
        int[] nums = new int[3];

        do {
            nums[0] = Randoms.pickNumberInRange(1, 9);
            nums[1] = Randoms.pickNumberInRange(1, 9);
            nums[2] = Randoms.pickNumberInRange(1, 9);
        } while (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]);
        return nums[0] * 100 + nums[1] * 10 + nums[2];
    }

    private static boolean checkUserAnswer(int userAnswer) {
        int ball = 0;
        int strike = 0;

        if (userAnswer % 10 == answer % 10)
            strike++;
        else {
            if (userAnswer % 10 == answer % 100 / 10 || userAnswer % 10 == answer / 100)
                ball++;
        }
        if (userAnswer % 100 / 10 == answer % 100 / 10)
            strike++;
        else {
            if (userAnswer % 100 / 10 == answer % 10 || userAnswer % 100 / 10 == answer / 100)
                ball++;
        }
        if (userAnswer / 100 == answer / 100)
            strike++;
        else {
            if (userAnswer / 100 == answer % 10 || userAnswer / 100 == answer % 100 / 10)
                ball++;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0)
            System.out.println(strike + "스트라이크");
        if (strike != 3)
            return false;
        return true;
    }

    private static boolean reGame() {
        int reGame;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            reGame = Integer.parseInt(Console.readLine());
            if (!(reGame == 1 || reGame == 2))
                throw new IllegalArgumentException();
        } catch (Exception e) {
            // exception test
            throw new IllegalArgumentException();
        }

        if (reGame == 2)
            return true;
        return false;
    }
}
