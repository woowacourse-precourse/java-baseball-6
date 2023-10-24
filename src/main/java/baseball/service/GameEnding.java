package baseball.service;

import baseball.input.EndReader;

public class GameEnding {
    public static boolean endGame(String message) {
        ServiceMessagePrinter.getServiceMessage("SUCCESS");
        ServiceMessagePrinter.getServiceMessage("RETRY");

        String line = EndReader.read();
        // 2를 입력하면 게임 종료
        if (Integer.parseInt(line) == 2) {
            return true;
        }
        // 1를 입력하면 게임 시작
        return false;
    }
}
