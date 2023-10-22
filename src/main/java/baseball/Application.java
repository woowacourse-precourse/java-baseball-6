package baseball;

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
