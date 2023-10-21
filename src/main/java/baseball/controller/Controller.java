package baseball.controller;


import baseball.service.Service;
import java.util.ArrayList;

public class Controller {

    private final Service service;
    private static int continueDecision = 1;
    public Controller() {
        this.service = new Service();
    }

    public void run() {  // 게임 실행
        while (continueDecision==1){
            settingGame();
            while (service.getStrike()<3){
                startGame();
            }
        }
        // 새로운 게임 생성(컴퓨터 랜덤 값 생성 및 저장) - settingGame();

        /* 게임 시작 - startGame();
        // 사용자 입력 받기
        // 두 값 비교
        // 점수 저장
        // 점수 출력
        */

        //if(strike==3)
        //selectContinueOrNot();
    }

    private void settingGame() {
        ArrayList<Integer> computerAnswer = service.getComputerAnswer();
        service.saveComputerAnswer(computerAnswer);
    }

    private void startGame() {
        int[] playerAnswer = service.getPlayerAnswer();
        service.compareTwoAnswer(playerAnswer);
        service.printResult(scoreTable);
    }

    private void selectContinueOrNot(){
        if(service.getPlayerDecision()==2)
    }

}
