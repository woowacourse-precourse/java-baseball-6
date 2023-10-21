package baseball;


import java.util.List;
import java.util.Objects;

public class CompareNumber {

    public boolean go(List<Integer> computerNum) {
        while(true){
            PlayerInput playerInput = new PlayerInput();
            if(checkScore(computerNum, playerInput.inputNumber)){
                return true;
            }
        }
    }

    public boolean checkScore(List<Integer> computerNum, List<Integer> inputNum) {
        Integer strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && Objects.equals(computerNum.get(i), inputNum.get(j))) {
                    strike++;
                } else if (Objects.equals(computerNum.get(i), inputNum.get(j))) {
                    ball++;
                }
            }
        }

        if(ball!=0 && strike!= 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if(ball == 0  && strike != 0){
            System.out.println(strike + "스트라이크");
        }else if(ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }else{
            System.out.println("낫싱");
        }

        if (strike == 3) { return true; }
        else { return false; }
    }
}