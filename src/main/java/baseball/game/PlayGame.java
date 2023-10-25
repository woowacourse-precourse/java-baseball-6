package baseball.game;

import baseball.view.InputView;
import baseball.view.OutputView;

public class PlayGame {
    private static final int BALL_NUM = 3;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private Balls balls;
    private Balls inputBalls;
    private int strike;
    private int ball;

    public boolean play(){
        boolean flag = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        balls = new Balls();

        while(true){
            inputBalls = inputView.getInputs();
            strike = balls.getStrike(inputBalls);
            ball = balls.getBall(inputBalls);

            if(strike == BALL_NUM){
                return outputView.playNewGame();
            }

            outputView.printResult(strike, ball);

        }
    }
}
