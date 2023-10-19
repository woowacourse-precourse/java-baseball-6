package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballGame = new BaseballGame();
    }
}

class BaseballGame{
    private final List<Integer> computer = new ArrayList<>();
    public void newBaseballGame(){
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
        if(rightInput(playerNumberInString)){
            while(player.size()<3){
                player.add(playerNumberInString.charAt(player.size())-'0');
            }
        }
        return player;
    }
    public boolean rightInput(String playerNumberInString){
        boolean rightInput = true;
        return rightInput;
    }
    public void compareNumber(){
        int strike = 0;
        while(strike != 3){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> player = readPlayerNumber();
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
    public void startGame(){
        newBaseballGame();
        compareNumber();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartOrExit = Console.readLine();
        if(restartOrExit.equals("1")){
            startGame();
        }else if(restartOrExit.equals("2")){
            System.out.print("게임 종료");
        }else{
            System.out.println("잘못된 입력");
        }
    }

}
