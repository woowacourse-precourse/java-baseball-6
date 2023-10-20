package baseball;

import baseball.Controller.PlayBall;
import baseball.service.PrintService;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        PlayBall playBall = new PlayBall();
        PrintService printService = new PrintService();

        boolean finish = false;

        while(!finish){
            playBall.play();
            finish = printService.printAfterFinish();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
