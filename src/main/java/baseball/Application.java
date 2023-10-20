package baseball;


import baseball.controller.StartGame;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        StartGame startGame = new StartGame();
        startGame.start();
    }
}