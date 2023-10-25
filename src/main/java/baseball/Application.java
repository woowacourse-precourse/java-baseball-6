package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printStartMessage();

        Game game = new Game();
        User user = new User();

        while (user.isContinued()) {
            game.init();

            while (!(game.getNumberOfStrike() == 3 && game.getNumberOfBall() == 0)) {
                game.reset();
                user.predict();
                game.countStrikeOrBall(user.getPrediction());
                printResultMessage(game.getNumberOfStrike(), game.getNumberOfBall());
            }

            user.decide();
        }
    }

    public static void printReGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printResultMessage(int numberOfStrike, int numberOfBall) {
        if (numberOfStrike == 3 && numberOfBall == 0) {
            System.out.println("3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (numberOfStrike == 0 && numberOfBall == 0) {
            System.out.println("낫싱");
            return;
        }

        if (numberOfStrike == 0) {
            System.out.printf("%d볼%n", numberOfBall);
            return;
        }

        if (numberOfBall == 0) {
            System.out.printf("%d스트라이크%n", numberOfStrike);
            return;
        }

        System.out.printf("%d볼 %d스트라이크%n", numberOfBall, numberOfStrike);
    }

    public static List<Integer> validateUserInput(String response) throws IllegalArgumentException {
        List<Integer> prediction = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            int nextNumber = response.charAt(i) - '0';
            if (!prediction.contains(nextNumber) && 1 <= nextNumber && nextNumber <= 9) {
                prediction.add(response.charAt(i) - '0');
            }
        }

        if (prediction.size() != 3 || response.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return prediction;
    }

    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
