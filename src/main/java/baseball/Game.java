package baseball;

import java.util.List;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();
    List<Integer> playerNumbers;
    List<Integer> computerNumbers;
    void start(){
        computerNumbers = computer.createComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true;
        while(flag) {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumbers = player.init();
            int[] result = getScore();
            String str = getResult(result);
            System.out.println(str);
            if(result[1]!=3) continue;
            retry();
            flag=false;
        }
    }

    int[] getScore(){
        int strike = 0;
        int ball = 0;
        for(int i=0; i<computerNumbers.size(); i++){
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if(computerNumber==playerNumber) {
                strike++;
                continue;
            }
            if(playerNumbers.contains(computerNumber)){
                ball++;
            }
        }
        int[] result = new int[]{ball, strike};
        return result;
    }

    String getResult(int[] result){
        StringBuilder sb = new StringBuilder();
        if(result[0]>0) sb.append(result[0]+"볼 ");
        if(result[1]>0) sb.append(result[1]+"스트라이크");
        if(result[0]==0 && result[1]==0) sb.append("낫싱");
        return sb.toString();
    }

    void retry(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = player.finishGame();
        if (playerInput == 1) {
            start();
        }
    }
}
