package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Constant.INTEGER_REGEX_EXCEPT_ZERO;
import static baseball.Constant.VALID_INPUT_LENGTH;

public class User {

    private String myNumber;
    private int ball;
    private int strike;

    public User(String input){
        validUserInput(input);
        myNumber = input;
        this.ball = 0;
        this.strike = 0;
    }

    /**
     *  입력이 유효한지 확인한다
     *  1. 문자가 입력이 되었는지
     *  2. 숫자만 입력했을 때 4자리 이상 입력했는지 확인한다.
     *  3. 중복되는 숫자가 있는지 확인한다.
     */
    private void validUserInput(String input){ //조건에 맞게 입력되었는지 확인
        if(input.length() != 3){ //입력의 길이가 3자가 아닌 경우
            throw  new IllegalArgumentException("입력은 3자리 숫자만 입력해야 합니다.");
        }

        if(!input.matches(INTEGER_REGEX_EXCEPT_ZERO)) { //입력에 1~9이외의 문자가 있는 경우
            throw new IllegalArgumentException("입력에 문자 입력과 숫자 0은 불가능합니다.");
        }

        //중복 수 확인 (ex) 339, 333, 787 등..)
        boolean[] chk = new boolean[10];
        for(char digit : input.toCharArray()){
            int num = Character.getNumericValue(digit);
            if(chk[num]) throw new IllegalArgumentException("중복되는 숫자입력은 불가능 합니다.");
            chk[num] = true;
        }

    }

    public String getMyNumber(){
        return this.myNumber;
    }

    //스트라이크 계산
    public void calculateStrike(Computer computer) {
        List<Integer> computerNumber = computer.getComputerNumber();
        int strike = 0;

        for (int i = 0; i < VALID_INPUT_LENGTH; i++) {
            if ((Character.getNumericValue(myNumber.charAt(i)) == computerNumber.get(i))) { //같은 위치에 같은 수가 있다면 strike
                strike++;
            }
        }

        this.strike = strike;
    }

    public void calculateBall(Computer computer) {
        List<Integer> computerNumber = computer.getComputerNumber();
        int ball = 0;

        for(int i=0; i < VALID_INPUT_LENGTH; i++){
            int number = Character.getNumericValue(myNumber.charAt(i));
            if(computerNumber.get((i+1)%3) == number || computerNumber.get((i+2)%3) == number){ //입력한 값은 맞지만 위치가 다를 때
                ++ball;
            }
        }

        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
