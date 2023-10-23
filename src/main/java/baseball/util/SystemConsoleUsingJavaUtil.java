package baseball.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemConsoleUsingJavaUtil implements ISystemConsole {

    private Scanner scanner;

    public SystemConsoleUsingJavaUtil() {
        this.open();
    }

    @Override
    public void open() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void close() {
        this.scanner.close();
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public String scan() {
        return this.scanner.nextLine();
    }

    @Override
    public int scanInt() {
        String userInput = this.scanner.nextLine();
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userInput);
    }
}
