package baseball.util;

public interface ISystemConsole {

    void open();

    void close();

    void println(String message);

    void print(String message);

    String scan();

    int scanInt();
}
