package io;

import camp.nextstep.edu.missionutils.Console;

public final class StandardReader implements Reader {
    public String readLine() {
        return Console.readLine().trim();
    }

}
