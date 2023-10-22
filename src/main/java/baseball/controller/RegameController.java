package baseball.controller;

import baseball.domain.Regame;

public class RegameController {


    public static Regame validateValue(int value) {
        for (Regame choice : Regame.values()) {
            if (choice.getValue() == value) {
                return choice;
            }
        }
        return Regame.OTHER_CHOICE;
    }
}
