package baseball;

import baseball.Controller.BaseballController;
import baseball.Model.Restart;
import baseball.View.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController();
        do {
            Output.printStartMessage();                 //"숫자 야구 게임을 시작합니다." 출력
            baseballController.start();
        }while(restart());

    }

    public static boolean restart(){
        Restart restart = new Restart();
        restart.setNumber();

        if(restart.getNumber().equals("1")){
            return true;
        }

        return false;
    }
}
