package baseball;

public class Game {
    public static void playBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int computerNumber = RandomNumberGenerator.generateRandomNumber();

        while (true) {
            int userNumber = UserInput.getUserInput();
            int[] result = NumberComparison.compareNumbers(computerNumber, userNumber);
            int strikes = result[0];
            int balls = result[1];

            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            } else {
                StringBuilder message = new StringBuilder();

                if (balls > 0) {
                    message.append(balls);
                    message.append("볼");
                }

                if (strikes > 0 && balls > 0) {
                    message.append(" ");
                }

                if (strikes > 0) {
                    message.append(strikes);
                    message.append("스트라이크");
                }

                System.out.println(message);
            }
        }
    }
}
