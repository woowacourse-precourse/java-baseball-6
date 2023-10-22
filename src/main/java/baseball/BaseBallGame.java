package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private String userInput;
    private List<Integer> userNumber;
    private List<Integer> computer;
    private final int NUM_LIMIT = 3;

    public void gameStart(){
        genNumber();
        while(callInput()){
            if(checkRule()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void genNumber(){
        this.computer = new ArrayList<>();
        while (computer.size() < NUM_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private boolean callInput(){
        System.out.print("숫자를 입력해주세요 : ");
        this.userInput = camp.nextstep.edu.missionutils.Console.readLine();
        if(checkValid(userInput)){
            this.userNumber = new ArrayList<>();
            for(int i = 0; i < NUM_LIMIT; i++) {
                this.userNumber.add(this.userInput.charAt(i) - '0');
            }
            return true;
        }
        else{
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백없이 입력하세요.");
        }
    }

    private boolean checkValid(String userInput) {
        /*
            condition1 = 입력한 숫자의 길이가 3인지.
            condition2 = 입력한 값이 숫자인지.
            condition3 = 입력한 숫자가 서로다른 숫자인지.
        */
        boolean condition1 = userInput.length() == NUM_LIMIT;
        boolean condition2 = checkNumber(userInput);
        if (condition1 && condition2) {
            boolean condition3 = checkDiffer(userInput);
            if(condition3){
                return true;
            }
            else{
                System.out.println("입력하는 숫자는 서로 달라야 합니다.");
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkDiffer(String userInput) {
        boolean[] numSet = new boolean[9];
        for(int i = 0; i < NUM_LIMIT; i++){
            int numValue = userInput.charAt(i) - '0' - 1;
            if (numSet[numValue]) {
                return false;
            }
            numSet[numValue] = true;
        }
        return true;
    }

    private boolean checkRule(){
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < NUM_LIMIT; i++){
            if(userNumber.get(i) == computer.get(i)){
                strike++;
            } else if (computer.contains(userNumber.get(i))) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 3){
            return true;
        }
        return false;
    }
}