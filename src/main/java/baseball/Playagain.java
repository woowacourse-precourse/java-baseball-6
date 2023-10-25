
package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Playagain {
    static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public boolean playagain(){
        System.out.println(RESTART);
        String answer = Console.readLine();
        if(Objects.equals(answer, "1")){
            return true;
        }
        return false;
    }
}
