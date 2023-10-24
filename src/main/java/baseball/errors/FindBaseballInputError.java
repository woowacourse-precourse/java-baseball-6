package baseball.errors;

import baseball.game.Rule;

public class FindBaseballInputError implements FindError{

    @Override
    public void matchLength(String str) {
        if(str.length() != Rule.MATCH_COUNT.getValue()){
            throw new IllegalArgumentException(Rule.MATCH_COUNT.getValue() + "개의 숫자를 입력하세요.");
        }
    }

    @Override
    public void verifyNonChar(String str) {
        for(int i = 0; i < str.length(); i++){
            if(!(str.charAt(i) > '0' && str.charAt(i) <= '9')){
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }
        }
    }

    @Override
    public void duplicatedNumber(String str) {
        for(int i = 0; i < str.length()-1; i++){
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j))throw new IllegalArgumentException("각각 다른 숫자를 입력해주세요.");
            }
        }
    }
}
