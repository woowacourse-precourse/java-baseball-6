package baseball;
//
//import java.util.ArrayList;
//
//public class Result {
//    public static int getBall(ArrayList<Integer> num, ArrayList<Integer> userNum) {
//        int i = 0;
//
//        for (int n: userNum) {
//            if (num.contains(n) && (num.indexOf(n) != userNum.indexOf(n)))
//                i++;
//        }
//        return i;
//    }
//
//    public static int getStrike(ArrayList<Integer> num, ArrayList<Integer> userNum) {
//        int i = 0;
//
//        for (int n: userNum) {
//            if (num.contains(n) && (num.indexOf(n) == userNum.indexOf(n)))
//                i++;
//        }
//        return i;
//    }
//
//}

import java.util.ArrayList;

public class Result {
    public static int getBall(ArrayList<Integer> num, ArrayList<Integer> userNum) {
        int ball = 0;

        for (int i = 0; i < num.size(); i++) {
            if (num.contains(userNum.get(i)) && num.get(i) != userNum.get(i)) {
                ball++;
            }
        }
        return ball;
    }

    public static int getStrike(ArrayList<Integer> num, ArrayList<Integer> userNum) {
        int strike = 0;

        for (int i = 0; i < num.size(); i++) {
            if (num.get(i) == userNum.get(i)) {
                strike++;
            }
        }

        return strike;
    }
}
