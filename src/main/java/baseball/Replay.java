package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Replay {
    public boolean ReplayGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        // readLine()을 통해 값을 읽는다.
        String input = Console.readLine();
        // equals를 통해 1일경우만 true를 return 한다.
        if(Objects.equals(input, "1")){
            return true;
        }
        else if(Objects.equals(input, "2")) {
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
