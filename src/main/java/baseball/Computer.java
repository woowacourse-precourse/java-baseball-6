package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    private int strike;
    private int ball;

    public static void lengthcheck(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        }//if
    }//end method

    public static ArrayList<String> collapseCheck(String userInput) {
        String[] inputArr = userInput.split("");
        ArrayList<String> user = new ArrayList<String>();
        for (int i = 0; i < inputArr.length; i++) {
            if (!user.contains(inputArr[i])) {
                user.add(inputArr[i]);
            } else if (user.contains(inputArr[i])) {
                throw new IllegalArgumentException("Invalid argument");
            }//if-else
        }//for
        return user;
    }//end method

    public static ArrayList<String> ComputerRandomNumber() {
        ArrayList<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String intToString = Integer.toString(randomNumber);
            if (!computer.contains(intToString)) {
                computer.add(intToString);
            }//if
        }//while
        return computer;
    }//end method

    public void CompareScroe(ArrayList<String> userNumber, ArrayList<String> computerRandomNumber) {
        for (int i = 0; i < 3; i++) {
            if (computerRandomNumber.get(i).equals(userNumber.get(i))) {
                this.strike++;
            } else if (userNumber.contains(computerRandomNumber.get(i))) {
                this.ball++;
            }//else-if
        }//for
    }//end method

    public String ScoreCheck() {
        String reply = "";

        if (this.strike == 3) {
            return "3스트라이크";
        }//if

        if (this.ball == 0 & this.strike == 0) {
            return reply = "낫싱";
        }//if

        if (this.ball > 0) {
            if (this.strike > 0) {
                return reply = ball + "볼 " + strike + "스트라이크";
            }//inner-if
            return reply = ball + "볼";
        }//outer-if

        if (this.strike > 0) {
            reply += this.strike + "스트라이크";
        }//if
        return reply;
    }//end method

}//end class
