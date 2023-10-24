package baseball;

import baseball.controller.BaseballController;
import baseball.view.StartView;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        StartView startView = new StartView();
        startView.start();

    }
}
