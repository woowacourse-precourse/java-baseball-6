
package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public Application() {
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String input;
        do {
            baseball.BaseballGame game = new baseball.BaseballGame();
            game.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        } while(input.equals("1"));

        System.out.println("안녕히 가세요!");
    }
}
