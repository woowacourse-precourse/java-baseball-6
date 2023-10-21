package baseball;

import baseball.game.ComputerGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String gameRepeat;
        do {
            ComputerGame game = new ComputerGame();
            game.gameStart();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameRepeat = Console.readLine();
        } while (gameRepeat.equals("1"));
    }
}