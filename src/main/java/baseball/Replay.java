package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Replay {
    public boolean ReplayGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if(Objects.equals(input, "1")){
            return true;
        }
        return false;
    }
}
