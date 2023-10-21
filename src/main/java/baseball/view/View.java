package baseball.view;

import baseball.controller.Controller;
import baseball.entity.Score;
import java.util.List;

public class View {
    private final Controller controller = new Controller();
    private final Score score = new Score();
    private boolean quit = false;

    //시작 시 프린트
    public void mainView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = controller.makeNumber();
        System.out.println(randomNumber); // TODO: 개발 이후에 해당 내용 삭제 필요
        while(!quit){
            System.out.print("숫자를 입력해주세요: ");
            List<Integer> userNumber = controller.getNumber();
            quit = controller.countScore(randomNumber,userNumber,score, quit);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

}
