package baseball;
import baseball.controller.BaseballController;
public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        try {
            baseballController.game();
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
