package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    ComputerFunction computerFunction = new ComputerFunction();
    public void run(){
        while(true) {
            playGame();

            if(!restartGame()) break;
        }
    }

    private void playGame(){
        int randomNumber = computerFunction.createRandomNumber();
        computerFunction.countCalculate(randomNumber);
    }

    private boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();
        int restart = Integer.parseInt(cmd);

        if(restart == 1){
            return true;
        }
        if(restart == 2){
            return false;
        }

        throw new IllegalArgumentException();
    }
}
