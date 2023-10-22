package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

final class Digit {

    private int digit;

    private Digit() {
    }

    static Digit generateRandomDigit() {
        Digit randomDigit = new Digit();
        randomDigit.digit = Randoms.pickNumberInRange(1, 9);
        return randomDigit;
    }

    static Digit generateFixedDigit(int target) {
        Digit fixedDigit = new Digit();
        fixedDigit.digit = target;
        if (fixedDigit.digit < 1 || fixedDigit.digit > 9) throw new IllegalArgumentException();
        return fixedDigit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit target = (Digit) o;
        return digit == target.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }
}
//
//
//class Test {
//    int digit;
//
//    private Test() {
//    }
//
//
////    Test randomTest()
//    static final class Random {
//
//        static public Test makeTest() {
//            return null;
//        }
//    }
//
//    static final class fixed {
//
//        public Test makeTest() {
//            return null;
//
//        }
//    }
//
//}
//
//
