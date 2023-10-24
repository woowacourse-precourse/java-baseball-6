package baseball;

import static baseball.Game.LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // TODO: 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
            Game game = new Game();

            // TODO: 입력값에 따라 처리
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                User user = new User(input, LENGTH);

                game.compare(user.getInput());
                game.printResult();

                if (game.isOver()) {
                    break;
                }
            }

            // TODO: 게임 종료
            System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();
            if (input.equals("2")) {
                break;
            } else if (!input.equals("1")) {
                throw new IllegalArgumentException();
            }
        }
    }
}