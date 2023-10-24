package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> inputUserNumber(){
        String s = Console.readLine();
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            inputNumber.add(s.charAt(i) - '0');
        }
        return inputNumber;
    }

    public static Result checkResult(List<Integer> computerNumber, List<Integer> inputNumber) {
        Result result = new Result();

        List<Integer> ballList = new ArrayList<>();
        ballList.addAll(computerNumber);

        for (int i = 0; i < 3; i++) {
            if(computerNumber.get(i).equals(inputNumber.get(i))){
                result.strike++;
                ballList.set(i, -1);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (ballList.contains(inputNumber.get(i))) {
                result.ball++;
            }
        }
        if(result.ball==0&&result.strike==0){
            result.isNothing=true;
        }
        return result;
    }

    public static class Result{
        int strike;
        int ball;
        boolean isNothing;
        public Result() {
            this.isNothing=false;
        }
    }
}
