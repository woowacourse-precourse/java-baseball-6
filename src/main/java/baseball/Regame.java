package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Regame {
    public boolean reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        if(answer.equals("1")){
            return true;
        }
        return false;
    }
}
