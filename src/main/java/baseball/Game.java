package baseball;

import java.util.List;

public class Game {

    private Computer computer;
    private Player player;
    int strike;
    int ball;

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
        player = new Player();
        player.createUserNum();

        check();
    }

    public void check(){
        List<Integer> computerNum = computer.getComputerNum();
        List<Integer> userNum = player.getUserNum();
        for(int i = 0; i < 3; i++){
            if(computerNum.get(i).equals(userNum.get(i))){
                strike++;
            }else if(computerNum.contains(userNum.get(i))){
                ball++;
            }
        }
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
    }






}
