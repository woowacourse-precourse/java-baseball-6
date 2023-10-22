package baseball;

import java.util.List;


public class Game {
    int strike;
    int ball;
    List<Integer> computerNum;
    int userNum;
    private boolean isPlaying = true;
    Computer computer = new Computer();
    User user = new User();

    public void gamePlay() {
        computer.setComputerNum();
        while (isPlaying) {
            user.setUserNum();
            isStrikeOrBall();
        }
    }

    void isStrikeOrBall() {
        computerNum = computer.getComputerNum();
        userNum = user.getUserNum();
        strike = 0;
        ball = 0;
        String userNumString = Integer.toString(userNum);
        for (int i = 0; i < computerNum.size(); i++) {
            int userDigit = Integer.parseInt(userNumString.charAt(i) + ""); // 문자를 정수로 변환
            if (computerNum.contains(userDigit)) {
                if (computerNum.get(i) == userDigit) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        call();
    }

    void call() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            isPlaying = false;
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}

