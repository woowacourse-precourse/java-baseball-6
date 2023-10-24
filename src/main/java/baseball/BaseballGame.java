package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void rePlay() {
        RandomNumber randomNumbers = new RandomNumber();
        List<Integer> cpuNewInput = randomNumbers.getRandomNumbers();
        System.out.println("컴퓨터 숫자:" + cpuNewInput);
        System.out.print("숫자를 입력해주세요 : ");
        String userNewInput = readLine();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.play(cpuNewInput, userNewInput);
    }

    public void play(List<Integer> target, String input) {
        List<Integer> reTarget = new ArrayList<>(target);

        int strike = 0;
        int ball = 0;
        String message = "";

        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputNumbers.add(Character.getNumericValue(input.charAt(i)));
        }

        for (int i = 0; i < 3; i++) {
            if (inputNumbers.get(i).equals(target.get(i))) {
                strike++;
                inputNumbers.set(i, -1);  // set to an impossible value
                target.set(i, -2);        // set to another impossible value
            }
        }

        if (strike == 3) {
            System.out.println(
                    strike + "스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userDecide = readLine();
            if (userDecide.equals("1")) {
                rePlay();
            } else if (userDecide.equals("2")) {
                // 종료
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (target.get(i).equals(inputNumbers.get(j))) {
                        if (i != j) {
                            ball++;
                        }
                    }
                }
            }
            if (strike == 0 && ball == 0) {
                message = "낫싱";
            } else {
                if (strike == 0) {
                    message = ball + "볼";
                } else if (ball == 0) {
                    message = strike + "스트라이크";
                } else {
                    message = ball + "볼 " + strike + "스트라이크";
                }
            }

            System.out.println(message);
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            play(reTarget, userInput);
        }
    }
}
