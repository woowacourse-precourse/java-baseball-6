package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemConsoleUsingMissionUtil implements ISystemConsole {

    @Override
    public void open() {

    }

    @Override
    public void close() {
        Console.close();
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
        return Console.readLine();
    }

    @Override
    public int scanInt() {
        String userInput = Console.readLine();
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userInput);
    }
}
