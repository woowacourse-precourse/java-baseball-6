package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String flag = "1";
        Computer computer = new Computer();
        computer.makeRandomNumbers();
        List<Integer> randNumbers = computer.getRandomNumbers();

        while (flag.equals("1")){

            User user = new User();
            Game game = new Game();

            user.inputNumbers();
            List<Integer> numbers = user.getNumbers();

            game.countStrike(randNumbers,numbers);
            game.countBall(randNumbers,numbers);
            int ballCount = game.getBall();
            int strikeCount = game.getStrike();
            game.printCount(ballCount, strikeCount);
            game.setZero();

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                flag = Console.readLine();
                if (flag.equals("1")) {
                    computer = new Computer();
                    computer.makeRandomNumbers();
                    randNumbers = computer.getRandomNumbers();
                }
            }
        }
    }
}
