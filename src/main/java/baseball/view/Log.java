package baseball.view;

public class Log {

    public static void info(String message) {
        if (message.contains(":")) {
            System.out.print(message);
            return;
        }
        System.out.println(message);

    }

    public static void result(int ball, int strike) {
        StringBuilder message = new StringBuilder();
        if (ball != 0) {
            message.append(ball).append("볼 ");
        }
        if (strike != 0) {
            message.append(strike).append("스트라이크\n");
        }
        if (message.isEmpty()) {
            message.append("낫싱\n");
        }
        System.out.println(message);
    }
}
