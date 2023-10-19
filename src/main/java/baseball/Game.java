package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Integer strike;
    private final Integer ball;

    public Game(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Game result(Balls computerBalls, Balls userBalls) {
        Integer strike = 0;
        Integer ball = 0;

        for (int i = 0; i < 3; i++) {
            Ball userBall = userBalls.get(i);
            if (computerBalls.isContain(userBall)) {
                if (computerBalls.get(i).equals(userBall)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        return new Game(strike, ball);
    }

    public static boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = Console.readLine();
        if (restartInput.equals("1")) {
            return true;
        }
        else if (restartInput.equals("2")) {
            return false;
        }
        else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
    public String printResult(){
        if (isNothing()) {
            return "낫싱";
        }
        if (isStrike()) {
            return strike + "스트라이크";
        }
        if (isBall()) {
            return ball + "볼";
        }
        return ball + "볼" + " " + strike + "스트라이크";
    }

    public boolean isThreeStrike(){
        if(allStrike()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean allStrike(){
        return this.strike == 3;
    }

    public boolean isNothing(){
        return this.strike == 0 && this.ball == 0;
    }

    public boolean isBall(){
        return this.ball > 0 && this.strike == 0;
    }

    public boolean isStrike(){
        return this.strike > 0 && this.ball == 0;
    }

    public boolean isStrikeAndBall(){
        return this.strike > 0 && this.ball > 0;
    }
}
