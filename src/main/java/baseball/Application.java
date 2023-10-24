package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            Shell.run();
        } finally {
            Console.close();
        }
    }
}
