package baseball.util.channel;


import baseball.util.enums.Command;
import camp.nextstep.edu.missionutils.Console;

public abstract class Reader {
    public static String read(Command command) {
        Printer.print(command.getCommand());
        String input = Console.readLine().trim();
        validate(input);
        if (command.equals(Command.PITCHING) && !(input.length() == 3)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

}
