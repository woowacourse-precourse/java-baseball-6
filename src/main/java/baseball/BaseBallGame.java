package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    ArrayList<Integer> answerNum = new ArrayList<>();
    ArrayList<Integer> userNum = new ArrayList<>();

    private Boolean isPlaying = false;

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (answerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNum.contains(randomNumber)) {
                answerNum.add(randomNumber);
            }
        }
    }

    public void chooseNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        String[] userNumAsString = input.split("");
        for(String str : userNumAsString){
            int number = Integer.parseInt(str);
            userNum.add(number);
        }
    }

    public void returnResult(){

    }

    public void exitGame(){

    }

    private void generateNum(){

    }
}
