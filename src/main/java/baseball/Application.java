package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다");
            Play play = new Play();
            if (play.game(input) == -1) {
                break;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        }


    }
}
