package baseball;

import camp.nextstep.edu.missionutils.Console;

class InputCommander {
    String receiveInput() {
        return Console.readLine();
    }

    void stopReceivingInput() {
        Console.close();
    }
}
