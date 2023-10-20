package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    List<Integer> comAnswer = new ArrayList<>();
    List<Integer> userAnswer = new ArrayList<>();

    void init(){
        comAnswer.clear();
        userAnswer.clear();
        while (comAnswer.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!comAnswer.contains(number)){
                comAnswer.add(number);
            }
        }
        userAnswer.clear();
    }

    void inputVal(){
        userAnswer.clear();
        System.out.printf("숫자를 입력해주세요 : ");
        String[] inputVal = Console.readLine().split("");
        try {
            IllegalArgumentException e = new IllegalArgumentException("입력값이 올바르지 않습니다.");
            for(int i = 0; i < inputVal.length; i++){
                userAnswer.add(Integer.parseInt(inputVal[i]));
            }
            if (userAnswer.size() != 3||userAnswer.contains(0)){
                e.printStackTrace();
                throw e;
            }
        } catch (IllegalArgumentException e) {
                throw e;
        }
    }
    
    boolean determine(){
        boolean result = false;
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < userAnswer.size(); i++){
            if(comAnswer.contains(userAnswer.get(i))){
                if(comAnswer.get(i) == userAnswer.get(i)){
                    strike++;
                }
                else{ball++;}
            }
        }

        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
        else if(ball != 0 && strike == 0){
            System.out.println(ball+"볼");
        }
        else if(ball == 0 && strike < 3){
            System.out.println(strike+"스트라이크");
        }
        else if(ball != 0 && strike < 3){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(strike == 3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = true;
        }
        return result;
    }

    boolean endGame(){
        boolean result = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameStatus = Console.readLine();
        if(gameStatus.equals("1")){
            result = false;
        }
        else if(gameStatus.equals("2")){
            result = true;
        }
        return result;
    }
}
