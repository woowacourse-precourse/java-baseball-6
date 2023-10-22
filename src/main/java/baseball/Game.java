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
    }
}

