package baseball.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static baseball.validation.InputValidation.*;

public class InputHandler {

    private final BufferedReader br;

    public InputHandler() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Integer scanInteger(){
        int input;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return input;
    }

    public List<Integer> inputToExpectedNumber(int input){
        List<Integer> expectedNums = new ArrayList<>();
        while(input > 0) {
            expectedNums.add(0, input % 10);
            input /= 10;
        }
        // 3가지 예외처리를 담당 1.예측값 충복체크 2.(1-9)범위 체크 3.3개의 숫자인지 체크
        if(!isSizeThree(expectedNums) || !isInRange(expectedNums) || isDuplicate(expectedNums)){
            throw new IllegalArgumentException();
        }

        return expectedNums;
    }
}
