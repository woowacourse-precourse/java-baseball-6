package baseball.model;

import baseball.view.Message;

import java.util.List;

public class InGame {
    static final int NUMBER_OF_BALLS = 3;
    static final int THREE_STRIKE = 3;
    public static boolean comparePlayerNumWithComputerNum(List<Integer> randomNum, List<Integer> playerNum) {
        int strike = 0;
        int ball = 0;
        boolean threeStrike = false;

        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            if (randomNum.get(i).equals(playerNum.get(i))) {
                strike += 1;
            } else if (randomNum.contains(playerNum.get(i))) {
                ball += 1;
            }
        }
        strikeAndBallMessage(strike, ball);
        if (strike == THREE_STRIKE) {
            threeStrike = true;
            Message.threeStrikeMessage();
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return threeStrike;
    }

    public static void strikeAndBallMessage(int strike, int ball) {
        if (strike > 0 && ball == 0) {
//            System.out.println(strike+"스트라이크");
            Message.onlyStrikeMessage(strike);
        } else if (strike == 0 && ball > 0) {
            Message.onlyBallMessage(ball);
//            System.out.println(ball+"볼");
        } else if (strike > 0 && ball > 0) {
            Message.ballWithStrikeMessage(strike, ball);
//            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            Message.noBallNoStrikeMessage();
//            System.out.println("낫싱");
        }
    }
}
