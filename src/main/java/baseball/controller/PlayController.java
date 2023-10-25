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
        //TODO : Output view 숫자 야구 게임을 시작합니다.
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
            //countController.count_ball(computer, user);
            //TODO : Output view 1볼 1스트라이크
            this.retry = !check_finish(countController.getStrike());
        }
        //TODO : Output view 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    }

    public boolean check_finish(int strike) {
        return strike==3;
    }
}
