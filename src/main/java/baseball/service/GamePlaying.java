package baseball.service;

import baseball.counter.Ball;
import baseball.counter.Strike;
import baseball.hint.Printer;
import baseball.hint.TotalMessage;
import baseball.input.Reader;

public class GamePlaying {
    public static String playingGame(String answer) {
        ServiceMessagePrinter.getServiceMessage("INPUT");

        String line = Reader.read();

        int ballCount = Ball.countBalls(answer, line);
        int strikeCount = Strike.countStrike(answer, line);

        String message = TotalMessage.sumMessage(ballCount, strikeCount);
        Printer.print(message);

        return message;
    }
}
