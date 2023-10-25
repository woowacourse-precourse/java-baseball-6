package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private List<Integer> computer;
    private int strike;
    private int ball;
    private boolean win=false;
    private boolean normal=true;
    private boolean restart=true;
    //c
    public void gameStart() throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(normal&&restart){
            makeRandomNumber();
            while(!win){
                System.out.print("숫자를 입력해주세요 : ");
                String answer=readLine();
                gameInputThrowException(answer);
                checkWin(answer);
                printResult();
                resetValue();
            }
            gameRestart();
        }
    }
    private void checkWin(String answer){
        for(int i=0;i<computer.size();i++){
            for(int j=0;j<answer.length();j++){
                if(computer.get(i)==(answer.charAt(j)-'0')){
                    if(i==j){
                        strike+=1;
                    }
                    else{
                        ball+=1;
                    }
                };
            }
        }
        if(strike==3){
            win=true;
        }
    }
    private void printResult(){
        if(win){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(strike==0&&ball==0){
            System.out.println("낫싱");
        }
        else if(strike!=0&&ball!=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(strike==0&&ball!=0) {
            System.out.println(ball+"볼");
        }
        else if(strike!=0&&ball==0){
            System.out.println(strike+"스트라이크");
        }
    }
    private void makeRandomNumber(){
        computer=new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private void resetValue(){
        strike=0;
        ball=0;
    }

    private void gameInputThrowException(String answer) throws IllegalArgumentException{
        boolean duplication=false;
        boolean integerValue=true;
        if(answer.length()!=3){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<3;i++){
            if((answer.charAt(i)-'0')<=0||(answer.charAt(i)-'0'>9)){
                integerValue=false;
            }
            for(int j=0;j<3;j++){
                if(i!=j){
                    if(answer.charAt(i)==answer.charAt(j)){
                        duplication=true;
                    }
                }
            }
        }
        if(duplication){
            throw new IllegalArgumentException();
        }
        else if(!integerValue){
            throw new IllegalArgumentException();
        }
    }
    private void gameRestart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartValue=readLine();
        if(restartValue.equals("2")){
            restart=false;
        }
        else if(restartValue.equals("1")){
            restart=true;
            win=false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
