package baseball.view;

public class Log {

    public static void info(String message) {
        if (message.contains(":")) {
            System.out.print(message);
            return;
        }
        System.out.println(message);

    }
}
