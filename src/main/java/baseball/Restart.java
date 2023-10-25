package baseball;

import java.util.Scanner;

public class Restart {
    public char RESTART_CHAR = '1';
    public boolean restart(){
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        if(answer == RESTART_CHAR){
            return true;
        }
        return false;
    }
}
