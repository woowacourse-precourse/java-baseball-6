package baseball.controller;

public class ControllerResolver {
    private final BaseballGameController baseballGameController;

    public ControllerResolver() {
        this.baseballGameController = new BaseballGameController();
    }

     public void run() {
         greet();
         //비교, 결과 추가 예정
     }

    private void greet() {
        baseballGameController.greet();
    }
}
