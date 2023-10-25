package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String input = Console.readLine();
            Play play = new Play();
            play.inputCheck(input);
            play.game(input);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String retry = Console.readLine();
            Newgame newgame = new Newgame();
            if (newgame.newGameCheck(retry) != 1) {
                break;
            }
        }
    }
}
