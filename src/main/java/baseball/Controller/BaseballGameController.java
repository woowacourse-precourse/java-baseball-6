package baseball.Controller;
import baseball.Service.GameService;
import baseball.domain.BaseballMember;

import static baseball.domain.BaseballMember.START_MESSAGE;
import static baseball.domain.BaseballMember.SUCCESS_AND_EXIT_MESSAGE;

public class BaseballGameController {

    final int SIZE = 3;
    //final int START_INCLUSIVE = 1;
    //final int END_INCLUSIVE = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();//Service 호출

    public void run() throws IllegalAccessException {  //예외처리

        System.out.println(START_MESSAGE);  //게임 시작 메세지

        System.out.println(SUCCESS_AND_EXIT_MESSAGE);   //게임 종료 메세지
            setGame();  //게임 세팅해줌 즉 컴퓨터가 랜덤수 생성
            startGame();
            endGame();
            retry_or_not();
    }



    private void setGame() {
        gameService.setGame();
    }

    private void startGame() throws IllegalAccessException {
        gameService.playGame();
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

    private void endGame() {
    }
    private void retry_or_not() {
    }





    public BaseballGameController(GameService gameService) {
        this.gameService = gameService;
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
                if((baseballMember.getRandomNumbers().get(i)) == (baseballMember.getMyinputlist().get(j))){
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
