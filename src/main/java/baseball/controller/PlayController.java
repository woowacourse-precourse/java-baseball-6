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
    public PlayController() {
        initGame();
    }

    private void initGame(){
        view.game_start();
        restart=true;
        while(restart) {
            playGame();
            check_rst();
        }

    }

    private boolean check_rst(){
        view.restart_msg();
        String userInput = view.restart_num();
        int rst_num = Integer.parseInt(userInput);
        if(rst_num!=1 && rst_num!=2){
            throw new IllegalArgumentException("1 또는 2로 입력해야합니다.");
        }
        if(rst_num==2) {
            return restart=false;
        }
        return restart=true;
    }

    private void playGame() {
        retry=true;
        randomGenerator = new RandomGenerator();
        List<Ball> computer = randomGenerator.getComputer();
        while(retry) {
            view.input_msg();
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
