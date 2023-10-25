package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameProgress {
    public static void gameStart() {
        int restartCount = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restartCount == 1){
            int resetCount = 1;

            List<Integer> computer = NumberControl.getRandomNumber();

            while (resetCount == 1) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> user = NumberControl.getUserNumber();

                List<Integer> result = checkNumber(computer, user);

                resetCount = printResult(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartCount = UserInput.restartGame();
        }
    }

    public static List<Integer> checkNumber(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int computerIndex = 0; computerIndex < 3; computerIndex++) {
            for (int userIndex = 0; userIndex < 3; userIndex++) {
                if (computerIndex == userIndex && computer.get(computerIndex) == user.get(userIndex)) {
                    strikeCount += 1;
                } else if (computer.get(computerIndex) == user.get(userIndex)) {
                    ballCount += 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }

    public static int printResult(List<Integer> result) {
        if (result.get(1) == 3) {
            System.out.println("3스트라이크");
            return 2;
        } else if (result.get(0) > 0 && result.get(1) > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result.get(0), result.get(1));
            return 1;
        } else if (result.get(0) > 0) {
            System.out.printf("%d볼\n", result.get(0));
            return 1;
        } else if (result.get(1) > 0) {
            System.out.printf("%d스트라이크\n", result.get(1));
            return 1;
        } else {
            System.out.println("낫싱");
            return 1;
        }
    }
}
