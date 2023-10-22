package baseball;

import java.util.ArrayList;
import java.util.List;

public class Controller{
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> playerNum = new ArrayList<>();
    private boolean flag = false;
    private static final String ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다 ! 게임 종료";

    Model model = new Model();
    View view = new View();
    public void gameStart(){
        view.startMassge();//view에서 startMassage() 실행
        computerNum = model.initComputerNum();// model에서 initComputerNum() 실행

        while(!flag) { //while을 통해 반복하고, flag로 반복을 제어한다.
            playerNum = model.initPlayerNum();// model에서 initPlaterNum() 실행
            countBallStrike(computerNum, playerNum);
        }

    }
    public void countBallStrike(List<Integer> computer, List<Integer> player){
        int ballCount = 0;
        int strikeCount = 0;
        ballCount = model.countball(computerNum,playerNum);
        strikeCount = model.countstrike(computerNum, playerNum);


    }





}