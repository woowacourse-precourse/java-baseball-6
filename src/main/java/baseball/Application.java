package baseball;

/**
 * 게임을 실행하는 클래스
 */
public class Application {

    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.playBaseball();
    }
}
