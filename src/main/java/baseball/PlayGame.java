package baseball;

import java.util.Scanner;

public class PlayGame {
    boolean isStart=false;
    Boolean isEnd=false;
    Judge judge=new Judge();
    Computer computer=new Computer();
    User user = new User();

    public void startGame(){
        computer.createComputerNumber();
        while(true) {
            user.inputUserNumber();
            int result[] = judge.outcome(computer, user);
            judge.printJudge(result);
            if (result[0] == 3) {
                break;
            }
        }
        if(!reStart()){
            System.exit(0);
        }
        else{
            startGame();
        }
    }

    public static boolean reStart() {
        Scanner sc = new Scanner(System.in);
        int i;
        boolean isRestart=false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            i = sc.nextInt();
            if (i == 1) {
                isRestart=true;
            } else if (i == 0) {
                isRestart=false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            //프로그램 종료
            System.exit(0);
        }
        return isRestart;
    }
}
