package player;

import camp.nextstep.edu.missionutils.Console;
import computer.CompareTwoValues;
import computer.RandomPickNumber;
import constant.GuideMessageConstant;
import constant.StringConstant;

public class Start {
    String restarting_Game = "1";

    public Start() {
        while (StringConstant.CONTINUE.equals(restarting_Game)) {
            System.out.println(GuideMessageConstant.START_MESSAGE);
            RandomPickNumber.randomPickNumber();
            CompareTwoValues compareTwoValues = new CompareTwoValues();

            while (compareTwoValues.strikeCount != 3) {
                Input.inputNumber();

                compareTwoValues.compareTwoValues(Input.inputNumber);
            }

            System.out.println(GuideMessageConstant.END_MESSAGE);
            System.out.println(GuideMessageConstant.RESTART_END_MESSAGE);
            try {
                restarting_Game = Console.readLine();
                if (!restarting_Game.equals("1") && !restarting_Game.equals("2")) {
                    throw new IllegalArgumentException(GuideMessageConstant.ERROR_ONE_OR_TWO_ENTER);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }


}
