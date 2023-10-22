package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    Number comNum = new Number();

    private void random_Number() {
        String random = "";
        while (random.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String randomString = String.valueOf(randomNumber);
            if (!random.contains(randomString)) {
                random += randomString;
            }
        }
        comNum = new Number(random);
        comNum.printNum();
    }

    public void start_Com() {
        comNum.clearNumber();
        random_Number();
    }

}


