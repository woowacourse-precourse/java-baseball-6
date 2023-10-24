package baseball;

import camp.nextstep.edu.missionutils.Console;
import game.GameBoard;
import game.Validation;

public class Application {

    private static GameBoard game;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game = new GameBoard();
        if(!game.board())
            System.out.println("게임을 완전히 종료합니다.");
    }
}
