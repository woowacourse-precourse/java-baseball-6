package baseball;

import game.GameBoard;

public class Application {

    private static GameBoard game = new GameBoard();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.board();
        System.out.println("게임을 완전히 종료합니다.");
    }
}
