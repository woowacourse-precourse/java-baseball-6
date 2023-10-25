package baseball.service;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberGenerator {


    private static final int COMPUTER_NUMBER_START_RANGE = 1;
    private static final int COMPUTER_NUMBER_LAST_RANGE = 9;

    private static ComputerNumberGenerator instance = new ComputerNumberGenerator();


    private ComputerNumberGenerator() {

    }

    public static ComputerNumberGenerator getInstance() {
        return instance;
    }

    public String generate() {
        StringBuilder comNumberBuilder = new StringBuilder();
        while (isShorterThanNumberLength(comNumberBuilder)) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_START_RANGE,
                COMPUTER_NUMBER_LAST_RANGE);
            if (isDuplicated(comNumberBuilder, randomNumber)) {
                continue;
            }
            comNumberBuilder.append(randomNumber);
        }
        return comNumberBuilder.toString();
    }

    private boolean isDuplicated(StringBuilder comNumberBuilder, int randomNumber) {
        return comNumberBuilder.toString().contains(String.valueOf(randomNumber));
    }


    private boolean isShorterThanNumberLength(StringBuilder comNumberBuilder) {
        return comNumberBuilder.length() < NumberConstant.INPUT_LENGTH.getNumber();
    }


}
