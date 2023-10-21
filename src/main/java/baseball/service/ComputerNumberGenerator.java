package baseball.service;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberGenerator {

    private static ComputerNumberGenerator instance = new ComputerNumberGenerator();

    private ComputerNumberGenerator() {

    }

    public static ComputerNumberGenerator getInstance() {
        return instance;
    }

    public String generate() {
        StringBuilder comNumberBuilder = new StringBuilder();
        while (isShorterThanNumberLength(comNumberBuilder)) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // builder 에서 tostring 에서 중복되면 더하지 않으면 되잖아??
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
