package baseball.view;

import baseball.model.GameResult;

public class ResultView {

    public void printInit(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printWin(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printBallAndStrikeCounts(GameResult gameResult){
        int balls = gameResult.getBall();
        int strikes = gameResult.getStrike();

        if(balls == 0 && strikes == 0) {
            System.out.println("낫싱");
        }

        if(balls != 0) {
            System.out.println(balls + "볼");
        }

        if(strikes != 0) {
            System.out.println(strikes + "스트라이크");
        }

        if(balls != 0 && strikes != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }
}
