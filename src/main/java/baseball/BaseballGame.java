package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

    private InputView inputView;
    private ResultView resultView;
    private Computer computer; //컴퓨터 숫자
    private Player player;  //플레이어 숫자

    int GAME_RUN;
    int STRIKE;
    int BALL;
    int NOTHING;

    //생성자
    public BaseballGame() {
        inputView = new InputView();
        resultView = new ResultView();
        computer = new Computer();
        player = new Player();
    }

    //초기화
    public void init(){
        GAME_RUN = 1;
        STRIKE = 0;
        BALL = 0;
        NOTHING = 0;
        player.init();
    }

    //실행
    public void run() {

        inputView.startView();

        while(true) {
            if(GAME_RUN == 2){
                break;
            }

            init();
            computer.random();

            while(true) {

                init();
                inputView.inputNumView();
                player.inputNum();

                for(int i=0; i <3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (computer.getComputer().get(i) == player.getPlayer().get(i)) {
                            STRIKE++;
                            break;
                        }
                        else if (computer.getComputer().get(i) == player.getPlayer().get(j)) {
                            BALL++;
                            break;
                        }
                    }

                }

                if(STRIKE == 3){
                    resultView.strikeView(STRIKE);
                    resultView.doneView();
                    break;
                }
                else if(STRIKE >= 1 || BALL >= 1){
                    if(STRIKE == 0){
                        resultView.ballView(BALL);
                    }
                    else if(BALL == 0){
                        resultView.strikeView(STRIKE);
                    }
                    else{
                        resultView.ballView(BALL);
                        resultView.strikeView(STRIKE);
                    }
                }
                else{
                    resultView.nothingView();
                }
            }

            inputView.runView();
            GAME_RUN = player.inputRun();
        }
    }
}
