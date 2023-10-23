package baseball.service;

import java.util.List;
public class CompareNumber {

    private static int strike = 0;
    private static int ball = 0;

    public boolean threeStrikes() {
        if (strike == 3){
            return true;
        }
        return false;
    }

    private static void printResult() {
        String result = "";
        if (ball > 0) {
            result += ball + "볼";
        }

        if (strike > 0) {
            if (!result.isEmpty()){
                result += " ";
            }
            result += strike + "스트라이크";
        }

        if (result.isEmpty()){
            result += "낫싱";
        }
        System.out.println(result);
    }

    public void checkStrike(List<Integer> computer, List<Integer> player) {
        strike = 0;
        ball = 0;
        for(int i = 0; i < computer.size(); i++){
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            }

            else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        printResult();
    }
}
