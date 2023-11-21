package baseball;

import baseball.controller.BaseBall;
import baseball.service.PrintService;

public class Application {
    public static void main(String[] args) {


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
