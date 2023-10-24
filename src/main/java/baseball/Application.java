package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            String randomNumber = NumberMaker.getRandomNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                // User Input
                String input = Console.readLine();

                // if input is not number, throw IllegalArgumentException and exit

                if (!Checker.isCorrectInput(input)) {
                    throw new IllegalArgumentException();
                }


                Integer balls = Checker.numberOfBalls(input, randomNumber);
                Integer strikes = Checker.numberOfStrikes(input, randomNumber);

                if (balls == 0 && strikes == 0) {
                    System.out.println("낫싱");
                    continue;
                }

                if (balls > 0 && strikes == 0) {
                    System.out.println(balls + "볼");
                    continue;
                }

                if (balls == 0 && strikes > 0) {
                    System.out.println(strikes + "스트라이크");

                    if (strikes == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                    continue;
                }

                if (balls > 0 && strikes > 0) {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String replay = Console.readLine();
            Integer answer = Integer.parseInt(replay);

            if (answer == 1) {
                continue;
            }

            if (answer == 2) {
                break;
            }

            throw new IllegalArgumentException();
        }
    }
}
