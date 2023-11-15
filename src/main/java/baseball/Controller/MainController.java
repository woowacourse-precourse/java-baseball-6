package baseball.Controller;
import baseball.Model.BaseballMember;
import baseball.View.EndView;
import baseball.View.StartView;


import static camp.nextstep.edu.missionutils.Console.readLine;  //내용 한 줄씩 읽어들이기

public class MainController {
    BaseballMember baseballMember = new BaseballMember();

    //computer가 랜덤으로 숫자를 생성함

    //내가 입력한 3개의 값을 리스트에 저장
    public void Myinputlist(){
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1) + "번째 수 입력: ");
            baseballMember.getMyinputlist().add(i, Integer.valueOf(readLine()));  //입력받고 myinputlist에 저장
        }
    }

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


    public void startGame() {
        MainController mainController = new MainController();
        StartView startView = new StartView();
        EndView endView = new EndView();


        //service의 ComputerRandomNumber 호출
        //service의 inputNumber 호출

        startView.startview();
        mainController.Myinputlist();
        mainController.numCheck();
        endView.endview();
    }

    public static void main(String[] args){ }
}
