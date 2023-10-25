package baseball;

import java.util.List;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static boolean reStart() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reStartButton = Console.readLine();

        if (reStartButton.equals("1")) {
            return true;
        } else if (reStartButton.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2 숫자 하나를 입력하세요.");
        }
    }

    private static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer;
        String player;

        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        do {
            System.out.printf("숫자를 입력해주세요 : ");
            player = Console.readLine();

            if (player.length() != 3) {
                throw new IllegalArgumentException("총 3개의 숫자를 입력해주세요.");
            }
        } while (guessIncorrect(computer, player));

    }

    private static boolean guessIncorrect(List<Integer> computerAnswer, String playerAnswer)
            throws IllegalArgumentException {

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < playerAnswer.length(); i++) {
            int playerAns = playerAnswer.charAt(i) - '0';
            if (playerAns < 1 || playerAns > 9) {
                throw new IllegalArgumentException("1 부터 9 사이의 숫자를 입력해주세요.");
            }

            for (int j = 0; j < i; j++) {
                if (playerAns == playerAnswer.charAt(j) - '0') {
                    throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
                }
            }

            int answer_index = computerAnswer.indexOf(playerAns);
            if (answer_index >= 0) {
                if (answer_index == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        if (strike + ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            play();
        } while (reStart());
    }
}