package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    private final int maxNumber = 9;
    private final int minNumber = 1;

    public List<Integer> makeRandomAnswerList() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            final int randomNumber = generateRandomNumber();
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        return answerList;
    }

    public int generateRandomNumber() {
        final int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
        return randomNumber;
    }
}
