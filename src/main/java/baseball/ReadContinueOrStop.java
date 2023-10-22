package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class ReadContinueOrStop {
    public int readContinueOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String scanContinueOrStop = Console.readLine();
        if (readContinueOrStopVerify(scanContinueOrStop)) {
            return readLineToInt(scanContinueOrStop);
        }
        return -1;
    }

    private boolean readContinueOrStopVerify(String scanContinueOrStop) {
        if (!Pattern.matches("^1|2$", scanContinueOrStop)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private int readLineToInt(String readLine) {
        return Integer.parseInt(readLine);
    }
}
