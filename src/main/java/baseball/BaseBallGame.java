package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallGame {
    private static final int NUMBER_COUNT = 3;
    private static final int RESTART_GAME = 1;


    public void gameStart() {
        gameStartMessage();
        conductGame();

    }

    private static void conductGame() {
        List<Integer> computer = getComputerNumbers();

        while (true) {
            List<Integer> player = getPlayerNumbers();
            boolean winOrLose = processPlayerScoreAndCheckGameResult(computer, player);
            if (winOrLose) {
                if (shouldRestartGame()) {
                    computer = getComputerNumbers();
                } else {
                    break;
                }
            }
        }
    }


    private static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static boolean processPlayerScoreAndCheckGameResult(List<Integer> computer, List<Integer> player) {
        if (isValid(player)) {
            int[] score = calculateScore(computer, player);
            broadcastGame(score);
            return isGameWon(score);
        }
        return false;
    }

    private static boolean shouldRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(input);
        int answer = Integer.parseInt(input);
        return answer == RESTART_GAME;
    }

    private static boolean isGameWon(int[] score) {
        return score[1] == NUMBER_COUNT;
    }

    private static void broadcastGame(int[] score) {
        int ball = score[0];
        int strike = score[1];
        if (strike == NUMBER_COUNT) {
            System.out.println(strike + "스트라이크");
            System.out.println(NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
    }

    private static int[] calculateScore(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        return (new int[]{ball, strike});
    }


    private static boolean isValid(List<Integer> player) {
        if (player.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("Input numbers should be " + NUMBER_COUNT + " digits.");
        }
        int frequency = 0;
        for (int i = 0; i < player.size(); i++) {
            frequency = Collections.frequency(player, player.get(i));
            if (frequency > 1) {
                throw new IllegalArgumentException("Duplicate numbers detected in player input.");
            }
        }
        return true;
    }

    private static List<Integer> getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(input);
        List<String> stringList = Arrays.asList(input.split(""));
        List<Integer> playerNumbers = new ArrayList<>();
        for (String str : stringList) {
            playerNumbers.add(Integer.parseInt(str));
        }
        return playerNumbers;
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
