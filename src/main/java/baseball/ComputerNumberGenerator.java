package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int DIGITS = 3;

    public static String generate() {
        String ComputerNumber = "";
        while (ComputerNumber.length() < DIGITS) {
            String randomNumber = GetRandomNumber();
            if (!ComputerNumber.contains(randomNumber)) {
                ComputerNumber += randomNumber;
            }
        }
        return ComputerNumber;
    }

    private static String GetRandomNumber() {
        return Integer.toString(pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
    }
}
