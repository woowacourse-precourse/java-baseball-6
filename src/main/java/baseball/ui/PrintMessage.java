package baseball.ui;

public interface PrintMessage {

    default void print(String message) {
        System.out.println(message);
    }

}
