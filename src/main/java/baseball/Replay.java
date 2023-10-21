package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Replay {
    public boolean ReplayGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        // readLine()을 통해 값을 읽는다.
        String input = Console.readLine();
        // equals를 통해 1일경우만 true를 return 한다.
        if(input == "1"){
            return true;
        }
        else if(input == "2") {
            return false;
        }
        // 잘못된 값을 입력할경우 IllegalArgumentException 오류를 발생시킨다.
        throw new IllegalArgumentException("잘못된 값 입력 (1 또는 2가 아닌 입력)");

    }
}
