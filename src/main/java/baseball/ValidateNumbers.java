package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeDigitException extends IllegalArgumentException {
    ThreeDigitException() {
        super("세 자리 숫자가 아닙니다.");
    }
}

class RangeException extends IllegalArgumentException {
    RangeException() {
        super("숫자의 범위는 1 이상 9 이하여야 합니다.");
    }
}

class DifferentEachOtherException extends IllegalArgumentException {
    DifferentEachOtherException() {
        super("세 숫자는 서로 달라야 합니다.");
    }
}

public class ValidateNumbers {
    List<Integer> numbers = new ArrayList<>();
    public ValidateNumbers(String in)
            throws ThreeDigitException, RangeException, DifferentEachOtherException {
       if(!isThreeDigit(in)){
           throw new ThreeDigitException();
       }
       if(!isValidateRangeNumbers(in)) {
           throw new RangeException();
       }
       if(!isDifferentEachOther(StringtoNumbers(in))) {
           throw new DifferentEachOtherException();
       }

       numbers = StringtoNumbers(in);
    }

    public int length() {
        return numbers.size();
    }

    public int getNumberAt(int i) {
        return numbers.get(i);
    }

    //내가 테스트 출력용으로 잠시 만들었음
    @Override
    public String toString() {
        String ret = "";
        for(int i=0;i<3;i++)
            ret += numbers.get(i).toString();
        return ret;
    }

    private boolean isThreeDigit(String in) {
        return in.length() == 3;
    }
    
    private boolean isValidateRangeNumbers(String in) {
        for(int i = 0; i < in.length() ; i++){
            if(!isValidateRangeNumber(Character.getNumericValue(in.charAt((i)))))
                return false;
        }
        return true;
    }

    private boolean isValidateRangeNumber(int number) {
        return number >= 1 && number <= 9;
    }
    
    private List<Integer> StringtoNumbers(String in) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < in.length() ; i++) {
            numbers.add(Character.getNumericValue(in.charAt((i))));
        }
        return numbers;
    }

    private boolean isDifferentEachOther(List<Integer> numbers) {
        Set<Integer> prevNums = new HashSet<>();
        for(int number : numbers){
            if(prevNums.contains(number))
                return false;
            prevNums.add(number);
        }
        return true;
    }
}
