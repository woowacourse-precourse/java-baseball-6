package baseball;

import baseball.BaseBallGameStart.ComputerNumbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGamePlay {

    public BaseBallGamePlay(ComputerNumbers computerNumbers) {
        play(computerNumbers);
    }

    private void play(ComputerNumbers computerNumbers) {
        boolean gamePlaying = true;
        while (gamePlaying) {
            output();
            String playerBall = input();
            checkInput(playerBall);
            PlayerNumbers playerNumbers = new PlayerNumbers(playerBall);
            gamePlaying = checkStrike(playerNumbers, computerNumbers);
        }
    }

    private void output() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String input() {
        return Console.readLine();
    }

    private void checkInput(String inputPlayerBall) {

        if (inputPlayerBall.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputPlayerBall.length(); i++) {
            char currentChar = inputPlayerBall.charAt(i);
            if (!Character.isDigit(currentChar)) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < inputPlayerBall.length(); i++) {
            char currentChar = inputPlayerBall.charAt(i);
            for (int j = i + 1; j < inputPlayerBall.length(); j++) {
                if (currentChar == inputPlayerBall.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }

    }

    private boolean checkStrike(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < playerNumbers.getPlayerNumbers().size(); i++) {
            if (playerNumbers.getPlayerNumbers().get(i) == computerNumbers.getNumbers().get(i)) {
                strike++;
                continue;
            }
            for (int j = 0; j < playerNumbers.getPlayerNumbers().size(); j++) {
                if (playerNumbers.getPlayerNumbers().get(i) == computerNumbers.getNumbers().get(j)) {
                    ball++;
                    continue;
                }
            }
        }

        refereeCall(strike, ball);
        return strike != 3;
    }

    private void refereeCall(int strike, int ball) {
        String call = "";

        if (ball > 0) {
            call += ball + "볼 ";
        }
        if (strike > 0) {
            call += strike + "스트라이크 ";
        }
        if (call.length() == 0) {
            call += "낫싱";
        }

        System.out.println(call);
    }

    static class PlayerNumbers {
        List<Integer> playerNumbers = new ArrayList<>();

        public PlayerNumbers(String playerBalls) {
            for (int i = 0; i < playerBalls.length(); i++) {
                char currentChar = playerBalls.charAt(i);
                playerNumbers.add(currentChar - '0');
            }
        }

        public List<Integer> getPlayerNumbers() {
            return playerNumbers;
        }
    }
}



