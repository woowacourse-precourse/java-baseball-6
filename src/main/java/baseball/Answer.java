package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

    private StringBuilder correct;

    public String makeAnswer() {
        correct = new StringBuilder();
        while (correct.length() < 3) {
            int r = Randoms.pickNumberInRange(1, 9);
            hasDuplicateNumber(r);
        }

        return correct.toString();
    }

    public void hasDuplicateNumber(int r) {
        String correctToString = correct.toString();
        String number = String.valueOf(r);
        if (!correctToString.contains(number)) {
            correct.append(number);
        }
    }

}
