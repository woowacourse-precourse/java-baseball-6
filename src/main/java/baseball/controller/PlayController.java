package baseball.controller;

public class PlayController {
    private CountController countController;
    private boolean restart;
    private boolean retry;
    public PlayController(){
        restart=true;
        retry=true;
        initGame();
    }

    private void initGame() {
        //TODO : Output view 숫자 야구 게임을 시작합니다.
        while(restart) {
            playGame();
            //TODO : Input view 1, 2 입력
        }

    }

    private void playGame() {
        //TODO : make computer randomInt
        while(retry) {
            //TODO : Input view 숫자를 입력해주세요 : 123
            countController = new CountController();
            countController.count_ball(computer, user);
            //TODO : Output view 1볼 1스트라이크
            this.retry = !check_finish(countController.getStrike());
        }
        //TODO : Output view 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    }


    private boolean check_finish(int strike) {
        return strike==3;
    }
}
