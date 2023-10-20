package baseball.util.view;


import camp.nextstep.edu.missionutils.Console;

public abstract class Reader {
    public static String read(Command command) {
        Printer.print(command.getCommand());
        return Console.readLine();
    }
}
