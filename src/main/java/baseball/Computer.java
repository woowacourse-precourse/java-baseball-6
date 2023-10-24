package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private Numbers computerNumbers;

    public Numbers initComputerNumbers() {
        computerNumbers = new Numbers();
        setComputerNumbersToRandom();
        return computerNumbers;
    }

    private void setComputerNumbersToRandom() {
        boolean[] visitedNumberArray = new boolean[10];
        int size = 0;
        while (size < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (checkDuplicated(visitedNumberArray, randomNumber)) continue;
            computerNumbers.addNumber(new Number(randomNumber));
            size++;
        }
    }

    private boolean checkDuplicated(boolean[] duplicateCheck, int num) {
        if (duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }

    public Judgement getJudgement(Numbers userNumbers) {
        return new Judgement(userNumbers, computerNumbers);
    }
}
