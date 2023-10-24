package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GlobalExcept.*;

public class Game {
    private final Integer strike;
    private final Integer ball;

    public static final Integer MAX_BALL_SIZE = 3;

    private final String NOTHING = "낫싱";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";

    public Game(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Game result(Balls computerBalls, Balls userBalls) {
        Integer strike = 0;
        Integer ball = 0;

        for (int i = 0; i < MAX_BALL_SIZE; i++) {
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
    public static String userInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        GlobalExcept.checkLength(userInput);
        GlobalExcept.checkAlphabetic(userInput);
        return userInput;
    }
    public static boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = Console.readLine();
        return checkRestart(restartInput);
    }
    public String printResult(){
        if (isNothing()) {
            return NOTHING;
        }
        else if (isStrike()) {
            return strike + STRIKE;
        }
        else if (isBall()) {
            return ball + BALL;
        }
        else if (isStrikeAndBall()) {
            return ball + BALL + " " + strike + STRIKE;
        }
        else {
            throw new IllegalArgumentException("잘못된 결과입니다.");
        }
    }

    public boolean isThreeStrike(){
        if(allStrike()){
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n",MAX_BALL_SIZE);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean allStrike(){
        return this.strike.equals(MAX_BALL_SIZE);
    }

    public boolean isNothing(){
        return this.strike.equals(0)  && this.ball.equals(0);
    }

    public boolean isBall(){
        return this.ball > 0 && this.strike.equals(0);
    }

    public boolean isStrike(){
        return this.strike > 0 && this.ball.equals(0);
    }

    public boolean isStrikeAndBall(){
        return this.strike > 0 && this.ball > 0;
    }
}
