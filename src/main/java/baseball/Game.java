package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Pattern;

public class Game {
    Number number = new Number();
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    private boolean exit = false;
    private static final int DIGITS = 3;
    private static final String RESTART = "1";

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = number.setAnswerNumbers();
        while(!exit){
            player = number.getInputNumbers();
            checkHint(computer,player);
        }
    }

    private void checkHint(List<Integer> answer, List<Integer> input){
        int strike = checkStrikes(answer,input);
        int ball = checkBalls(answer, input);

        if(ball != 0){
            if(strike != 0){
                System.out.println(ball+"볼"+" "+strike+"스트라이크");
            }
            System.out.println(ball+"볼");
        }
        if(strike != 0){
            System.out.println(strike+"스트라이크");
        }
        else {
            System.out.println("낫싱");
        }

        if(strike == DIGITS){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            setRestartOrExit();
        }

    }

    private int checkBalls(List<Integer> answer, List<Integer> input){
        int num = 0;
        for(int i =0; i < answer.size(); i++){
            if(!Objects.equals(answer.get(i), input.get(i)) && input.contains(answer.get(i))){
                num++;
            }
        }
        return num;
    }

    private int checkStrikes(List<Integer> answer, List<Integer> input){
        int num = 0;
        for(int i =0; i < answer.size(); i++){
            if(Objects.equals(answer.get(i), input.get(i))){
                num++;
            }
        }
        return num;
    }

    private void setRestartOrExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(!checkInput(input)){
            throw new IllegalArgumentException();
        }

        if(Objects.equals(input, RESTART)){
            computer = number.setAnswerNumbers();
            return;
        }
        exit = true;
    }

    private boolean checkInput(String str){
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(str).matches();
    }


}
