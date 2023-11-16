package baseball.Controller;
import baseball.domain.BaseballMember;
import baseball.Service.ComupterRandomNumber;

import baseball.View.EndView;
import baseball.View.StartView;

import static baseball.domain.BaseballMember.START_MESSAGE;

public class BaseballGameManager {
    private final ComupterRandomNumber comupterRandomNumber;    //Service 호출

    public void startGame() {

        System.out.println(START_MESSAGE);
        do {
            comupterRandomNumber.play();
        }while ();
    }
        //게임 플레이 se

//        BaseballGameManager mainController = new BaseballGameManager(comupterRandomNumber);
//
//        StartView.startview();
//        EndView.endview();
//
//
//        //service의 ComputerRandomNumber 호출
//        //service의 inputNumber 호출
//
//        mainController.Myinputlist();
//        mainController.numCheck();
    }

    public BaseballGameManager(ComupterRandomNumber comupterRandomNumber) {
        this.comupterRandomNumber = comupterRandomNumber;
    }

    //computer가 랜덤으로 숫자를 생성함

    BaseballMember baseballMember = new BaseballMember();

    //판별하기
    public void numCheck(){

        //EndView endView = new EndView();

        for (int i = 0; i < 3; i++) {
            int strike = 0;
            int ball = 0;

            for (int j = 0; j < 3; j++) {
                if((baseballMember.getComputer().get(i)) == (baseballMember.getMyinputlist().get(j))){
                    strike += 1;
                    System.out.println(strike + "스트라이크");
                }
//              else {
//               throw new IllegalArgumentException();
//           }
            }
        }

        //endView.endview();//종료화면

    }




    public static void main(String[] args){ }
}
