package baseball.Controller;
import baseball.Model.BaseballMember;
import baseball.View.EndView;
import baseball.View.StartView;
import camp.nextstep.edu.missionutils.Randoms;


import static camp.nextstep.edu.missionutils.Console.readLine;  //내용 한 줄씩 읽어들이기

public class MainController {
    BaseballMember bm = new BaseballMember();

    private final String GAME_RESTART = "1";
    private final String GAME_END = "2";


    //computer가 랜덤으로 숫자를 생성함
    public void computerRandom() {
        while ((bm.getComputer().size()) < 3) {   //리스트에 들어있는 원소 수
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1~9까지의 수 랜덤으로 집어넣음
            if (!bm.getComputer().contains(randomNumber)) { //중복방지
                bm.getComputer().add(randomNumber);
            }
        }
    }

    //내가 입력한 3개의 값을 리스트에 저장
    public void Myinputlist(){
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1) + "번째 수 입력: ");
            bm.getMyinputlist().add(i, Integer.valueOf(readLine()));  //입력받고 myinputlist에 저장
        }
    }

    //판별하기
    public void numCheck(){

        //EndView endView = new EndView();

        for (int i = 0; i < 3; i++) {
            if((bm.getMyinputlist().get(i)) == bm.getComputer().get(i)){
                System.out.println("");

            }
            else{

            }


        }

        //만약 아니다 그럼 예외 처리 하기
        //endView.endview();//종료화면


    }


    public void startGame() {
        MainController mainController = new MainController();
        StartView startView = new StartView();
        EndView endView = new EndView();
        mainController.computerRandom();
        startView.startview();
        mainController.Myinputlist();
        mainController.numCheck();
        endView.endview();
    }

    public static void main(String[] args){ }
}
