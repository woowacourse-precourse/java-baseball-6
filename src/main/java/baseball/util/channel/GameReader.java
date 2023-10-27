package baseball.util.channel;


import baseball.util.enums.Command;
import camp.nextstep.edu.missionutils.Console;

public abstract class GameReader {
    public static String read(Command command) {
        Printer.print(command.getCommand());
        String input = Console.readLine().trim();
        validate(input);

        // 사용자의 Pitching 입력 값을 요청하는 명령인데 입력한 숫자가 3 자리가 아닐 경우
        if (command.equals(Command.PITCHING) && !(input.length() == 3)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * @param input 사용자의 입력 값
     * @exception IllegalArgumentException 빈 값을 입력한 경우 & 슷지가 아닌 값을 입력한 경우
     */
    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

}
