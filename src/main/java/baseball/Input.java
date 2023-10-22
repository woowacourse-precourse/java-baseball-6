package baseball;

import camp.nextstep.edu.missionutils.Console;

final class Input {
    String receiveInput() {
        return Console.readLine();
    }

    void stopReceivingInput() {
        Console.close();
    }
}
