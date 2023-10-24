package baseball.info;

import java.util.Scanner;

/**
 * 야구 게임 진행을 위한 정보 값들
 */

public class BaseballGameInfo {

    // 입력을 위한 스캐너 필드
    private Scanner input;

    // 게임 종료 여부 판단 필드
    private boolean GameEnding;



    // 컴퓨터의 야구게임 숫자를 담을 필드
    private String randomNumber;

    // 유저의 야구게임 결과를 담을 필드들
    private int ball;
    private int strike;

    // 유저의 입력을 담을 필드들
    private String baseballNum;
    private String select;


    // 생성자
    public BaseballGameInfo() {
        this.input = new Scanner(System.in);
        this.GameEnding = false;
        this.ball = 0;
        this.strike = 0;
    }

    // 게터, 세터들
    public Scanner getInput() {
        return input;
    }

    public boolean getGameEnding() {
        return GameEnding;
    }

    public void setGameEnding(boolean gameEnding) {
        GameEnding = gameEnding;
    }


    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public String getBaseballNum() {
        return baseballNum;
    }

    public void setBaseballNum(String baseballNum) {
        this.baseballNum = baseballNum;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
}
