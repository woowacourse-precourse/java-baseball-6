package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class Digit {

    final int digit;

    Digit() {
        this.digit = Randoms.pickNumberInRange(1, 9);
    }
}