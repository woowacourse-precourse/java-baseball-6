package baseball;

import baseball.game.model.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {

            System.out.println("숫자 야구 게임을 시작합니다.");

            Game game = new Game();
            List<Integer> randomAnswer = game.createRandomAnswer();

            while (true) {
                String input = Console.readLine();
                game.validateInput(input);
                String hint = game.getHint(input);
                System.out.println(hint);
                if (hint.equals("3스트라이크")) {

                    //todo : 반복 로직
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    input = Console.readLine();
                    if (input.equals("2")) {
                        Console.close();
                        return;
                    }else if (input.equals("1")) {
                        break;
                    }else {
                        throw new IllegalArgumentException("1또는 2의 값을 입력해야합니다.");
                    }

                }
            }


        }

    }

}
