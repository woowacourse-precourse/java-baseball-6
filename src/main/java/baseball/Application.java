package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int isProceed = 1;
    static Computer computer;
    static Player player;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        computer = new Computer();
        player = new Player();

        doGame();

    }

    private static void doGame(){

        while( !computer.getResult(player.getNumber(computer.DIGIT))){
            continue;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        doAgain();
    }
    private static void doAgain(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num= -1;
        try{
            num = Integer.parseInt(readLine());
            if (num==1){
                if(computer.reset())
                    doGame();
            }
        }catch(IllegalArgumentException e){
            System.exit(0);
        }
    }

}
