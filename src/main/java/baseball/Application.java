package baseball;
import baseball.BaseBall;
import baseball.computer.Score;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
    		System.out.println("숫자 야구 게임을 시작합니다.");
    	BaseBall baseball = new BaseBall();
    	baseball.run();
    }
}
