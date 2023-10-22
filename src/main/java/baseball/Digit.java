package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

class Digit {

    private final int digit;

    Digit() {
        this.digit = Randoms.pickNumberInRange(1, 9);
    }

    Digit(int target) {
        this.digit = target;
        if(digit < 1 || digit > 9) throw new IllegalArgumentException();
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
