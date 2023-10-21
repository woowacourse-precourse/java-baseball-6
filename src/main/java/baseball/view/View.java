package baseball.view;

import baseball.controller.Controller;
import java.util.List;

public class View {
    private final Controller controller = new Controller();

    //시작 시 프린트
    public void mainView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = controller.makeNumber();
    }

}
