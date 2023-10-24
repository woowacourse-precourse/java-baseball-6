package baseball.View;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String getUserInput(){
        System.out.println("숫자를 입력해주세요 :");
        return Console.readLine();
    }
}
