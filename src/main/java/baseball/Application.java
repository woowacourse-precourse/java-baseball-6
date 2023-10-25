package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isAnswer;

        while (true) {
            Game game = new Game();
            isAnswer = false;
            while (!isAnswer) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                List<Integer> number = NumberConverter.from(input);
                isAnswer = game.play(number);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();

            if (input.equals("1")) {
                continue;
            }
            if (input.equals("2")) {
                break;
            }
        }
    }
}
