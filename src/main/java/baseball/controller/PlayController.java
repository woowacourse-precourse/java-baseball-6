package baseball.controller;

import baseball.model.Ball;
import baseball.view.View;

import java.util.List;

public class PlayController {
    private CountController countController;
    private RandomGenerator randomGenerator;
    private View view = new View();
    private boolean restart;
    private boolean retry;
    public PlayController() throws Exception {
        restart=true;
        retry=true;
        initGame();
    }

    private void initGame() throws Exception {
        view.game_start();
        while(restart) {
            playGame();
            //TODO : Input view 1, 2 입력
        }

    }

    private void playGame() throws Exception {
        randomGenerator = new RandomGenerator();
        List<Ball> computer = randomGenerator.getComputer();
        while(retry) {
            String user_input = view.user_balls();
            List<Ball> user = Ball.of(user_input);
            countController = new CountController();
            countController.count_ball(computer, user);
            count_result(countController.getStrike(), countController.getBall());
            this.retry = !check_finish(countController.getStrike());
        }
        view.game_end();
    }

    private void count_result(int strike, int ball) {
        if(strike==0 &&ball==0) {
            view.nothing_result();
            return;
        }
        if(strike==0){
            view.ball_result(ball);
            return;
        }
        if(ball==0){
            view.strike_result(strike);
            return;
        }
        view.ballAndStrike_result(strike, ball);
    }

    public boolean check_finish(int strike) {
        return strike==3;
    }
}
