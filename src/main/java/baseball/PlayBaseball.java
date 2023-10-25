package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


import java.util.*;

public class PlayBaseball {

    public List<Integer> answerGenerator() {
        List<Integer> selectedNumbers = new ArrayList<>();
        while (selectedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!selectedNumbers.contains(randomNumber)) {
                selectedNumbers.add(randomNumber);
            }
        }
        return selectedNumbers;
    }

    public boolean compareTry(List<Integer> answer, int[] userTry) {
        int strikes = 0, balls = 0;
        boolean nothing = false;
        for (int i = 0; i < 3; i++) {
            int userNumber = userTry[i];
            if (answer.get(i) == userNumber) {
                strikes++;
            } else if (answer.contains(userNumber)) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        } else {
            if (balls > 0) {
                System.out.print(balls + "볼 ");
            }
            if (strikes > 0) {
                System.out.print(strikes + "스트라이크 ");
            }
        }
        System.out.println();
        return strikes != 3;
    }

    public void playBall() {
        List<Integer> answer = answerGenerator();
        boolean doContinue;

        while (true) {
            try {
                System.out.print("숫자를 입력하세요 : ");
                String input = Console.readLine();
                String[] userInput = input.split("");

                if (userInput.length != 3) {
                    throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
                }

                int[] userTry = new int[3];
                for (int i = 0; i < 3; i++) {
                    userTry[i] = Integer.parseInt(userInput[i]);
                }
                doContinue = compareTry(answer, userTry);
                if (!doContinue) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
                break;
            }
        }
    }
}
