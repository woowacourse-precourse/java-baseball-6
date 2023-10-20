package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GameView implements View {

    private static String makeMessage(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            return String.format(
                    "%d%s %d%s",
                    ball,
                    ClientMessage.BALL.getMessage(),
                    strike,
                    ClientMessage.STRIKE.getMessage()
            );
        }
        if (strike > 0) {
            return String.format(
                    "%d%s",
                    strike,
                    ClientMessage.STRIKE.getMessage()
                    );
        }
        if (ball > 0) {
            return String.format(
                    "%d%s",
                    ball,
                    ClientMessage.BALL.getMessage()
            );
        }
        return ClientMessage.NOTHING.getMessage();
    }

    private static String makeMessage(ClientMessage clientMessage) {
        return clientMessage.getMessage();
    }

    @Override
    public void start() {
        System.out.println(makeMessage(ClientMessage.START));
    }

    @Override
    public List<Integer> input() {
        System.out.print(makeMessage(ClientMessage.INPUT_MESSAGE));
        String input = Console.readLine().strip();
        List<String> inputList = null;

        if (!input.matches("[1-9]{3}"))
            throw new IllegalArgumentException();

        inputList = Arrays.asList(input.split(""));

        if (new HashSet<>(inputList).size() != 3)
            throw new IllegalArgumentException();

        return inputList
                .stream()
                .map(c -> Integer.parseInt(c))
                .toList();
    }

    @Override
    public void result(int strike, int ball) {
        System.out.println(makeMessage(strike, ball));
    }

    @Override
    public void end() {
        System.out.println(makeMessage(ClientMessage.END_MESSAGE));
    }

    @Override
    public boolean restartQuestion() {
        System.out.println(makeMessage(ClientMessage.RESTART_QUESTION_MESSAGE));

        String input = Console.readLine().strip();

        if (!input.matches("[12]{1}"))
            throw new IllegalArgumentException();

        return input.equals("1") ? true : false;
    }
}
