package baseball.verifier;

import java.util.HashSet;
import java.util.Set;

import static baseball.Application.NUM_DIGITS;

public class BaseBallNumVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        if(input.length()!=NUM_DIGITS)//3개 미만, 또는 초과해서 입력된 경우에 대한 예외처리
            throw new IllegalArgumentException("3개의 수를 입력하지 않았습니다.");

        Set<Character> uniqueChars = new HashSet<>();

        for(char char_num : input.toCharArray()){
            if(char_num<'1' || char_num>'9')//1~9가 아닌 값에 대한 예외처리
                throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");

            if(!uniqueChars.add(char_num))//중복된 수를 넣으려고 하는 경우 예외처리
                throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }
    }
}
