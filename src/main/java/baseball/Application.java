package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        try{
            BaseballController baseballController = new BaseballController();
            baseballController.startGame();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
