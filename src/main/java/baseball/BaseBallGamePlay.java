package baseball;

import baseball.BaseBallGameStart.ComputerNumbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGamePlay {
    //TODO: 게임진행

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

        // 3자리 수가 아니면 에러발생
        if (inputPlayerBall.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 현재 문자가 숫자인지 확인 아니면 에러발생
        for (int i = 0; i < inputPlayerBall.length(); i++) {
            char currentChar = inputPlayerBall.charAt(i);
            if (!Character.isDigit(currentChar)) {
                throw new IllegalArgumentException();
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

        if (strike + ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else {
            System.out.println("낫싱");
        }

        return strike != 3;
    }

    static class PlayerNumbers {
        List<Integer> playerNumbers = new ArrayList<>();

        public PlayerNumbers(String playerBalls) {
            // 변환
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



