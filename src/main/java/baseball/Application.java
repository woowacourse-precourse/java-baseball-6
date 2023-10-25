package baseball;

import baseball.controller.Game;

public class Application {
    public static void main(String[] args) {

        do {
            Game game = Game.create(); //game 객체 생성
            game.start(); //game 시작
        }while(Game.isRestart());

        // TODO: 프로그램 구현
    }
}
