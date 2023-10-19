package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private int answerNum;
    private Boolean isPlaying = false;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void chooseNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();
        returnResult(userNum);
    }

    public String returnResult(String userNum){
        return "ok";
    }

    public void exitGame(){

    }

    private void generateNum(){

    }
}
