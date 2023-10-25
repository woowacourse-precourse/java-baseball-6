package baseball;

import baseball.Controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.gameStart();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("예상하지 못한 예외입니다.");
        }
    }
}
