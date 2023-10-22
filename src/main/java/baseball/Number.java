package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Number {
    private static final int NUMBERS_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    
    // 컴퓨터의 숫자를 설정하는 메서드
    public String setComputersNumber() {
        Set<Integer> digits = new LinkedHashSet<>();
        
        while (digits.size() < NUMBERS_LENGTH) {
            digits.add(getRandomNumber());
        }
        
        return convertIntegerSetToString(digits);
    }
    
    // Randoms 클래스를 통해 난수를 가져오는 메서드
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
    
    // Integer 타입의 Set을 String 타입의 문자열로 변환하는 메서드
    private String convertIntegerSetToString(Set<Integer> digits) {
        StringBuilder result = new StringBuilder();
        
        for (Integer digit : digits) {
            result.append(digit);
        }
        
        return String.valueOf(result);
    }
}
