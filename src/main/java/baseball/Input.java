package baseball;

import camp.nextstep.edu.missionutils.Console;

final class Input {

    private Input() {
    }

    static String receiveInput() {
        return Console.readLine();
    }

    static void stopReceivingInput() {
        Console.close();
    }
}
