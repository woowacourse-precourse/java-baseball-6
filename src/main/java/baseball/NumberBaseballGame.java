package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.GameUtils.*;

public class NumberBaseballGame {
    private static List<Integer> answer = new ArrayList<>();
    private NumberBaseballGame(){
    }
    public static void initGame() {
        answer = generateRandomNumber();
        Game();
    }

    //입력 + 처리 -> 이 함수를 반복할 것.
    private static void Game(){
        List<Integer> userInput = Input.getUserInput();
        //결과 알려줘
        for (Integer i : answer) {
            System.out.println("i = " + i);
        }
        caculateCount(userInput);
    }
    private static void caculateCount(List<Integer> userInput){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0;i<3;i++){
            int cur = userInput.get(i);
            if(answer.get(i).equals(cur)){
                strikeCount++;
            }
            else if(answer.contains(cur)){
                ballCount++;
            }
        }
        getResult(strikeCount,ballCount);
    }


    private static void getResult(int strikeCount, int ballCount){
        if (strikeCount==3&&ballCount==0){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
        }
        else if(strikeCount==0&&ballCount==0){
            System.out.println("낫싱");
            Game();
        }
        else if(ballCount==0){
            System.out.println(strikeCount+"스트라이크");
            Game();
        }
        else if(strikeCount==0){
            System.out.println(ballCount+"볼");
            Game();
        }else{
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
            Game();
        }
    }

    private static void restart() {
        if(Input.askRestart().equals("1")){
            initGame();
        }
        else return;
    }

}
