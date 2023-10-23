package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    public static void run() {
        String stop;
        int strike;
        int ball;

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            computer.setAnswer();
            strike = 0;

            while (strike != 3) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();

                User user = new User();
                user.setGuess(inputNumber);
                List<Integer> guess = user.getGuess();

                if (!User.isInputNumber(guess)) {
                    throw new IllegalArgumentException("3자리 수를 입력하셔야 합니다.");
                } else {
                    strike = Game.countStrike(computer, guess);
                    ball = Game.countBall(computer, guess);
                    Game.printGame(strike, ball);
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            stop = Console.readLine();
        } while (stop.equals("1"));
    }

    private static int countStrike(Computer computer, List<Integer> guess) {
        int count = 0;

        for (int i = 0; i < computer.getAnswer().size(); i++) {
            if (computer.getAnswer().get(i).equals(guess.get(i))) {
                count++;
            }
        }

        return count;
    }

    private static int countBall(Computer computer, List<Integer> guess) {
        int count = 0;

        for (int i = 0; i < computer.getAnswer().size(); i++) {
            for (int j = 0; j < guess.size(); j++) {
                if (i != j && computer.getAnswer().get(i).equals(guess.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void printGame(int strike, int ball) {

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼\n", ball);
        }
    }
}
