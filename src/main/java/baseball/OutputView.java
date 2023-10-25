package baseball;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void displayScore(int strikes, int balls) {
        String scoreMessage = getDisplayMessage(strikes, balls);
        System.out.println(scoreMessage);
    }

    public static String getDisplayMessage(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        return generateMessage(strikes, balls);
    }

    private static String generateMessage(int strikes, int balls) {
        StringBuilder messageBuilder = new StringBuilder();

        if (balls > 0) {
            messageBuilder.append(balls)
                    .append("볼");
        }

        if (strikes > 0) {
            if (balls > 0) {
                messageBuilder.append(" ");
            }
            messageBuilder.append(strikes)
                    .append("스트라이크");
        }

        return messageBuilder.toString();
    }

    public static void displayGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
