package baseball;

import java.util.Map;

public class Output {
    public void printBaseballResult(Map<String, Integer> baseballResult){
        int strikeCount = baseballResult.get("strike");
        int ballCount = baseballResult.get("ball");
        printStrikeAndBall(strikeCount, ballCount);
    }
    private void printStrikeAndBall(int strikeCount, int ballCount){
       if(strikeCount == 0 && ballCount == 0){
           System.out.println("낫싱");
           return;
       }
       if(strikeCount == 0){
           System.out.println(ballCount + "볼");
           return;
       }
       if(ballCount == 0){
           System.out.println(strikeCount + "스트라이크");
           return;
       }
       if(ballCount > 0 && strikeCount > 0){
           System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
       }
    }
    public void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void askUserToInsertNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void askUserToResumeOrNot(){
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
