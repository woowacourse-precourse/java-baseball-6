package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame{
    private final List<Integer> computerNumber = new ArrayList<>();
    private final List<Integer> playerNumber = new ArrayList<>();
    private int strike;
    private int ball;
    private void newGame(){
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
    private void rightInput(String playerNumberInString){
        if (playerNumberInString.length()!=3) {
            throw new IllegalArgumentException();
        }
        if (playerNumberInString.charAt(0)
                == playerNumberInString.charAt(1)
                || playerNumberInString.charAt(1)
                == playerNumberInString.charAt(2)
                || playerNumberInString.charAt(0)
                == playerNumberInString.charAt(2)) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<3;i++){
            if(!Character.isDigit(playerNumberInString.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
    private void readPlayerNumber(){
        playerNumber.clear();
        System.out.print("\n숫자를 입력해주세요 : ");
        String playerNumberInString = Console.readLine();
        rightInput(playerNumberInString);
        while(playerNumber.size()<3){
            playerNumber.add(playerNumberInString.charAt(playerNumber.size())-'0');
        }
    }
    private void clearStrikeAndBall(){
        strike = 0;
        ball = 0;
    }
    public void printResult(){
        if(ball !=0){
            System.out.print(ball +"볼 ");
        }
        if(strike !=0){
            System.out.print(strike +"스트라이크");
        }
        if(ball ==0&& strike ==0){
            System.out.print("낫싱");
        }
    }
    private void compareNumber(){
        for(int i = 0; i<3;i++){
            if(Objects.equals(computerNumber.get(i), playerNumber.get(i))){
                strike++;
            }else if (Objects.equals(playerNumber.get(i),computerNumber.get((i+1)%3))
                    ||Objects.equals(playerNumber.get(i),computerNumber.get((i+2)%3))){
                ball++;
            }
        }
    }
    private void gameProcess() {
        clearStrikeAndBall();
        while(strike != 3){
            clearStrikeAndBall();
            readPlayerNumber();
            compareNumber();
            printResult();
        }
    }
    private void restartOrExit(){
        String restartOrExit = Console.readLine();
        if(restartOrExit.equals("1")){
            startGame();
        }else if(restartOrExit.equals("2")){
            System.out.print("게임 종료");
        }else{
            System.out.println("잘못된 입력, 다시 입력하세요.");
            restartOrExit();
        }
    }
    public void startGame() {
        newGame();
        gameProcess();
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartOrExit();
    }
}
