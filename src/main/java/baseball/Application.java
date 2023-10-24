package baseball;

/**
 * 숫자 야구 게임의 실행을 담당하는 애플리케이션 클래스입니다.
 * 
 * @author 김지환
 */
public class Application {
    public static void main(String[] args) {
        BaseballGameImpl baseball = new BaseballGameImpl();
        while(true) {
            baseball.startGame();
            if(baseball.endGame()) {
                break;
            }
        }
    }    
}
