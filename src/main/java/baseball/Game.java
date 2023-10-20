package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> randomNum = new ArrayList<>();
    List<Integer> answerNum = new ArrayList<>();

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다");

        do{
            initGame();
            playTurn();
        }while ();

    }
    public void initGame(){
        randomNum.clear();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }
    public void playTurn(){
        String answer;
        do{
            answer = getNum();
            changeIntArray(answer);
        }while ();
    }
    public void changeIntArray(String answer) {
        answerNum.clear();
        for (int i = 0; i < 3; i++) {
            answerNum.add(answer.charAt(i) - '0');
        }
    }
    public String getNum(){
        System.out.print("\n숫자를 입력해주세요 : ");
        String answer = Console.readLine();
        illegalArgumentException(answer);
        return answer;
    }
    public void illegalArgumentException(String answer) {
        if(answer.length()!=3 || !answer.matches("\\d+")){
            throw new IllegalArgumentException();
        }
    }

}

