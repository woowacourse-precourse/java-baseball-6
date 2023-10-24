package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    List<Integer> player = new ArrayList<>();
    List<Integer> computer = new ArrayList<>();

    public void setGame(List<Integer> player, List<Integer> computer){
        this.player = player;
        this.computer = computer;
    }

    public boolean play(){
        int ball = 0;
        int strike = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i<3; i++){
            visited.put(player.get(i),i);
        }
        for(int i =0 ;i<3; i++){
            if(visited.containsKey(computer.get(i))){
                if(visited.get(computer.get(i)) == i) strike++;
                else ball++;
            }
        }
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else {
            if(ball == 0 && strike != 0){
                System.out.println(strike+"스트라이크");
            }
            else if(ball != 0 && strike == 0){
                System.out.println(ball+"볼");
            }
            else if(ball!=0 && strike!=0){
                System.out.println(ball+"볼 " + strike+"스트라이크");
            }
            if(ball == 0 && strike == 0){
                System.out.println("낫싱");
            }
            return false;
        }
    }
}