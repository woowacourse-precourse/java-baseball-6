package baseball;

import java.util.List;

public class Game {

    private Computer computer;
    private Player player;
    int strike;
    int ball;
    boolean EXIT = false;

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
        System.out.println(computer.getComputerNum());
        player = new Player();
        while(!EXIT){
            resetResult();
            player.createUserNum();
            check();
            printResult();
        }

    }
    public void resetResult(){
        ball = 0;
        strike = 0;
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

    }

    public void printResult(){
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if(strike == 3){
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            EXIT = true;
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }
        System.out.println(sb);
    }
}
