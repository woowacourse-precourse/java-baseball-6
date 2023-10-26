package baseball.service;

import java.util.List;

import static baseball.message.Message.THREE_STRIKES;

public class CompareNumber {

    private static int strike = 0;
    private static int ball = 0;

    public boolean threeStrikes() {
        if (strike == THREE_STRIKES){
            return true;
        }
        return false;
    }

    private void printResult() {
        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball + "볼");
        }

        if (strike > 0) {
            if (!result.isEmpty()){
                result.append(" ");
            }
            result.append(strike + "스트라이크");
        }

        if (result.isEmpty()){
            result.append("낫싱");
        }
        System.out.println(result.toString());
    }

    private void initStatus() {
        strike = 0;
        ball = 0;
    }

    private void updateBallAndStrike(List<Integer> computer, List<Integer> player) {
        for(int i = 0; i < computer.size(); i++){
            int computerNum = computer.get(i);
            int playerNum = player.get(i);
            if (computerNum == playerNum) {
                strike++;
            }

            else if (computer.contains(playerNum)){
                ball++;
            }
        }
    }


    public void checkBallAndStrike(List<Integer> computer, List<Integer> player) {
        initStatus();
        updateBallAndStrike(computer, player);
        printResult();
    }
}
