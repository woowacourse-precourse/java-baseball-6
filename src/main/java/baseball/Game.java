package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    Hint hint = new Hint();
    Message message = new Message();
    public void play(){
        message.startMessage();
        //상대방(컴퓨터)의 Random 3자리 수 생성
        ArrayList<Integer> computerNumber = computer.getRandomNumber();
        System.out.print("상대방(컴퓨터)랜덤 숫자 제대로 나오는 것 확인 : ");
        System.out.println(computerNumber);

        //여기서 계속 반복됨.
        int strike = 0;
        while(strike != 3){
            ArrayList<Integer> userNumber = user.readNumber();
            hint.allScore(computerNumber, userNumber);
            strike = hint.getStrikeScore();
            message.hintMessage(hint.getStrikeScore(), hint.getBallScore());
        }
        message.correctAnswerMessage();
        reStart();
    }
    public void reStart() throws IllegalArgumentException{
        message.endOrRestartMessage();
        if(endOrRestart() == 1){
            play();
        }
    }
    //예외처리: 문자x,숫자1,2이외의 모든 수x
    public int endOrRestart() throws IllegalArgumentException{
        int flag = Integer.parseInt(Console.readLine());
        if(flag==0||flag>2){
            throw new IllegalArgumentException();
        }
        return flag;
    }
}