package baseball;

import baseball.Controller.BaseBall;
import baseball.service.PrintService;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        BaseBall baseBall = new BaseBall();
        PrintService printService = new PrintService();

        boolean finish = false;

        while(!finish){
            baseBall.playBall();
            finish = printService.printAfterFinish();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
