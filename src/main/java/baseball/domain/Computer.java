package baseball.domain;

import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final BaseballNumber comNum;

    public Computer() {
        this.comNum = new BaseballNumber();
    }

    public void generateRandomNumber() {
        String random = "";
        while (random.length() < Constants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String randomString = String.valueOf(randomNumber);
            if (!random.contains(randomString)) {
                random += randomString;
            }
        }
        comNum.setNumber(random);
        System.out.println("random = " + random);
    }

    public BaseballNumber getComputerNumber() {
        return comNum;
    }
}