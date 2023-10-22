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
        game();
    }

    //입력 + 처리 -> 이 함수를 반복할 것.
    private static void game(){
        List<Integer> userInput = Input.getUserInput();
        caculateCount(userInput);
    }
    private static void caculateCount(List<Integer> userInput){
        int strike = 0;
        int ball = 0;
        ball = countBall(userInput);
        strike = countStrike(userInput);
        getResult(strike,ball);
    }

    private static int countStrike(List<Integer> userInput) {
        int strike = 0;
        for (int i = 0;i<answer.size();i++){
            int cur = userInput.get(i);
            if (answer.contains(cur)&&answer.indexOf(cur)==i){
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(List<Integer> userInput) {
        int ball = 0;
        for(int i = 0 ; i<answer.size();i++){
            int cur = userInput.get(i);
            if (answer.contains(cur)&&answer.indexOf(cur)!=i){
                ball++;
            }
        }
        return ball;
    }


    private static void getResult(int strikeCount, int ballCount){
        if (strikeCount==3&&ballCount==0){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
        }
        else if(strikeCount==0&&ballCount==0){
            System.out.println("낫싱");
            game();
        }
        else if(ballCount==0){
            System.out.println(strikeCount+"스트라이크");
            game();
        }
        else if(strikeCount==0){
            System.out.println(ballCount+"볼");
            game();
        }else{
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
            game();
        }
    }

    private static void restart() {
        if(Input.askRestart().equals("1")){
            initGame();
        }
        else return;
    }

}
