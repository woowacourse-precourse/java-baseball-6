package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGamePlay {
    //TODO: 게임진행

    public BaseBallGamePlay() {
        play();
    }

    private void play() {
        output();
        String playerBall = input();
        PlayerNumbers playerNumbers = new PlayerNumbers(playerBall);

        System.out.println(playerNumbers.getPlayerNumbers());
    }

    private void output() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String input() {
        String inputPlayerBall = Console.readLine();

        // 입력값이 3자리가 아닐 경우 에러발생
        if (inputPlayerBall.length() != 3) {
            throw new IllegalArgumentException();
        }

        return inputPlayerBall;

    }

    static class PlayerNumbers {
        List<Integer> playerNumbers = new ArrayList<>();

        public PlayerNumbers(String playerBalls) {

            // 변환
            for (int i = 0; i < playerBalls.length(); i++) {
                char currentChar = playerBalls.charAt(i);

                // 현재 문자가 숫자인지 확인 아니면 에러발생
                if (Character.isDigit(currentChar)) {
                    playerNumbers.add(currentChar - '0');
                    continue;
                }
                throw new IllegalArgumentException();
            }
        }

        public List<Integer> getPlayerNumbers() {
            return playerNumbers;
        }

    }

}



