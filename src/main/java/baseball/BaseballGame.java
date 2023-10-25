package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    int ball = 0;
    int strike = 0;
    int out = 0;

    public List createRandomNumber() {  // 리스트 형태로 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("랜덤 수 생성"+computer);
        return computer;
    }

    public List<Integer> StringToIntList(String input) {
        int inputNumber = Integer.parseInt(input);
        List<Integer> inputNumberList = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++){
            inputNumberList.add(inputNumber % 10);
            inputNumber /= 10;
        }
        Collections.reverse(inputNumberList);
        return inputNumberList;
    }

    public void strikeBallOut(List<Integer> inputNumber, List<Integer> computerNumber){

        for (int i = 0; i < 3; i++){
            if (inputNumber.get(i) == computerNumber.get(i)){
                this.strike++;
            }
            else if (computerNumber.contains(inputNumber.get(i))){
                this.ball++;
            }
            else {
                this.out++;
            }
        }
    }

    public boolean checkResult(){
        boolean result = true;

        if (this.ball != 0){
            System.out.print(this.ball+"볼 ");
        }
        if (this.strike != 0){
            System.out.print(this.strike+"스트라이크");
        }
        if (this.strike == 3){
            System.out.print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = false;
        }
        if (this.out == 3){
            System.out.print("낫싱");
        }
        System.out.println();

        this.strike = 0;
        this.ball = 0;
        this.out = 0;

        return result;
    }

}
