package baseball.service;

import java.util.List;
public class CompareNumber {

    private static int strike = 0;
    private static int ball = 0;

    public void checkStrike(List<Integer> computer, List<Integer> player) {
        for(int i = 0; i < computer.size(); i++){
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            }

            else if (computer.contains(player.get(i))) {
                ball++;
            }
        }

        if (strike == 3){
            System.out.println(strike + "스트라이크");
        }

        else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        else if (strike > 0){
            System.out.println(strike + "스트라이크");
        }

        else if (ball > 0){
            System.out.println(ball + "볼");
        }

        else {
            System.out.println("낫싱");
        }
    }
}
