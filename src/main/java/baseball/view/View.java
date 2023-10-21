package baseball.view;

import baseball.controller.Controller;
import java.util.List;

public class View {
    private final Controller controller = new Controller();

    //시작 시 프린트
    public void mainView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = controller.makeNumber();
        System.out.println(randomNumber); // TODO: 개발 이후에 해당 내용 삭제 필요
        System.out.print("숫자를 입력해주세요: ");
        List<Integer> userNumber = controller.getNumber();
    }

}
