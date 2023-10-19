package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame{
    private final List<Integer> computer = new ArrayList<>();
    private boolean isError = false;
    public void newGame(){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public List<Integer> readPlayerNumber(){
        String playerNumberInString = Console.readLine();
        List<Integer> player = new ArrayList<>();
        rightInput(playerNumberInString);
        while(player.size()<3){
            if(isError){
                break;
            }
            player.add(playerNumberInString.charAt(player.size())-'0');
        }
        return player;
    }
    public void rightInput(String playerNumberInString) {
        try{
            if (playerNumberInString.length()!=3
                    ||playerNumberInString.charAt(0)
                    ==playerNumberInString.charAt(1)
                    ||playerNumberInString.charAt(1)
                    ==playerNumberInString.charAt(2)
                    ||playerNumberInString.charAt(0)
                    ==playerNumberInString.charAt(2)){
                throw new IllegalArgumentException();
            }
            for(int i = 0; i<3;i++){
                if(!Character.isDigit(playerNumberInString.charAt(i))){
                    throw new IllegalArgumentException();
                }
            }
        }catch(IllegalArgumentException illegalArgumentException){
            System.out.println("Illegal Argument Exception");
            isError = true;
        }

    }
    public void compareNumber(){
        int strike = 0;
        while(strike != 3){
            System.out.print("\n숫자를 입력해주세요 : ");
            List<Integer> player = readPlayerNumber();
            if(isError){
                break;
            }
            strike = 0;
            int ball = 0;
            for(int i = 0; i<3;i++){
                if(Objects.equals(computer.get(i), player.get(i))){
                    strike++;
                }else if (Objects.equals(player.get(i),computer.get((i+1)%3))
                        ||Objects.equals(player.get(i),computer.get((i+2)%3))){
                    ball++;
                }
            }
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
    }
    public void restartOrExit(){
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
    public void startGame(){
        newGame();
        compareNumber();
        if(!isError){
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartOrExit();
        }
    }
}
