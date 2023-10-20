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
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }while (restartGame());

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
        }while (checkResult()!=3);
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

    public int checkResult(){

        int strike=0;
        int ball=0;

        for(int i = 0; i<3;i++){

            int num =answerNum.get(i);

            if(randomNum.get(i)==num){
                strike++;
            } else if (randomNum.contains(num)) {
                ball++;
            }

        }

        printCheckResult(ball, strike);
        return strike;
    }

    public void printCheckResult(int ball, int strike) {

        if(ball !=0){
            System.out.print(ball +"볼 ");
        }
        if(strike !=0){
            System.out.print(strike + "스트라이크");
        }
        if(strike ==0 && ball ==0){
            System.out.print("낫싱");
        }

    }

    public boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." );
        String s = Console.readLine();

        if(s.equals("1")){
            return true;
        } else if (s.equals("2")) {
            return false;
        }else {
            throw new IllegalStateException();
        }
    }

}

