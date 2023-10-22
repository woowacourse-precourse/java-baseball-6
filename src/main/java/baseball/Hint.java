package baseball;

import java.util.List;

public class Hint {
    private String name;
    private int ballCounter = 0; // static 추가 -> 제거
    private int strikeCounter = 0; // static 추가 -> 제거
    private char[] threeNumbersOfPlayer;
    private List<Integer> threeRandomNumbersOfComputer;

    Hint(String threeNumbersOfPlayer, List<Integer> threeNumbersOfComputer) {
        this.threeNumbersOfPlayer = threeNumbersOfPlayer.toCharArray();
        this.threeRandomNumbersOfComputer = threeNumbersOfComputer;
    }

//    private static char[] convertIntToCharArr(int num) {
//        String numInStr = Integer.toString(num);
//        char[] numInCharArr = new char[numInStr.length()];
//
//        for (int i=0; i<numInStr.length(); i++) {
//            numInCharArr[i] = numInStr.charAt(i);
//        }
//
//        return numInCharArr;
//    }

    public void calculateTheNumberOfBallAndStrike() {
        for (int i = 0; i< threeRandomNumbersOfComputer.size(); i++) {
            for (int j = 0; j< threeNumbersOfPlayer.length; j++) {
                if (threeRandomNumbersOfComputer.get(i) == (threeNumbersOfPlayer[j] - '0')) {
                    if (i == j) {
                        strikeCounter++;
                    } else {
                        ballCounter++;
                    }
                }
            }
        }
    }

//    public static void resetCounters() {
//        strikeCounter = 0;
//        ballCounter = 0;
//    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public String toString() {
        String hint = "";

        if (ballCounter != 0) {
            hint = ballCounter + "볼 ";

            if (strikeCounter != 0) {
                hint += strikeCounter + "스트라이크";
            }
        } else {
            if (strikeCounter != 0) {
                hint += strikeCounter + "스트라이크";
            } else {
                hint = "낫싱";
            }
        }

//        if (ballCounter != 0) {
//            hint = ballCounter + "볼 ";
//        }
//
//        if (strikeCounter != 0) {
//            hint += strikeCounter + "스트라이크";
//        }

        return hint;
    }
}
