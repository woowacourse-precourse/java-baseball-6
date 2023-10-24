package baseball;

import java.util.ArrayList;
import java.util.List;

public class Controller{
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> playerNum = new ArrayList<>();
    private boolean flag = false;
    private static final String THREE_STRIKE = "3스트라이크 ";

    Model model = new Model();
    View view = new View();
    public void gameStart(){
        view.startMassage();//view에서 startMassage() 실행
        computerNum = model.initComputerNum();// model에서 initComputerNum() 실행

        while(!flag) { //while을 통해 반복하고, flag로 반복을 제어한다.
            playerNum = model.initPlayerNum();// model에서 initPlaterNum() 실행
            countBallStrike(computerNum, playerNum);
        }
    }
    public void countBallStrike(List<Integer> computer, List<Integer> player){
        int ballCount = 0;
        int strikeCount = 0;
        ballCount = model.countBall(computerNum,playerNum);
        strikeCount = model.countStrike(computerNum, playerNum);
        sendHint(model.initHint(ballCount, strikeCount));
    }
    public void sendHint(String hint){
        view.printHint(hint);
        if (hint.equals(THREE_STRIKE)){
            view.printEndGame();
            sendRestartOrExit();
        }
    }
    public void sendRestartOrExit(){
        view.printRestartOrExit();
        setFlage(model.inputRestartOrExit());
    }
    public void setFlage(int setNum){
        if (setNum == 2){
            flag = true;
        }
        else{
            computerNum = model.initComputerNum();
        }

    }
}