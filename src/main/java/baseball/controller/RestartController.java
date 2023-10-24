package baseball.controller;

import baseball.domain.Restart;

public class RestartController {
    
    public static Restart validateValue(int value) {
        for (Restart choice : Restart.values()) {
            if (choice.getValue() == value) {
                return choice;
            }
        }
        return Restart.OTHER_CHOICE;
    }
}
