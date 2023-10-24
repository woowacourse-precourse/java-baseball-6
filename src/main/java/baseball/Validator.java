package baseball;

import java.util.Collections;
import java.util.List;

public class Validator {
    //1. 1-9인가?
    //2. 3자리인가?
    //3. 중복된 숫자가 없는가?
    //4. 숫자로만 이루어져 있는가?
    static final String WORNG_ISNUMRANGE_MSG = "1-9까지의 숫자만 입력해주세요.";
    static final String WORNG_ISNUMSIZE_MSG = "3자의 숫자만 입력해주세요. ex)123";
    static final String WORNG_ISNUMDUPICATION_MSG = "중복되지 않는 숫자만 입력해주세요.";
    static final String WORNG_ISNUMONLY_MSG = "숫자만 입력해주세요.";

    public void isVaildNumber(List<Integer> num, String strNum){
        if(!isNumRange(num)){
            throw new IllegalArgumentException(WORNG_ISNUMRANGE_MSG);
        } else if (!isNumSize(num)) {
            throw new IllegalArgumentException(WORNG_ISNUMSIZE_MSG);
        } else if (!isNumDuplication(num)) {
            throw new IllegalArgumentException(WORNG_ISNUMDUPICATION_MSG);
        } else if (!isNumOnly(strNum)) {
            throw new IllegalArgumentException(WORNG_ISNUMONLY_MSG);
        }
    }

    private boolean isNumRange(List<Integer> num){ //1-9인가
        for(Integer smaple : num){
            if(smaple<1 || smaple>9){
                return false;
            }
        }
        return true;
    }
    private boolean isNumSize(List<Integer> num){ //문자가 3개인가?
        if(num.size() != 3){
            return false;
        }
        return true;
    }
    private boolean isNumDuplication(List<Integer> num){ //중복된 숫자가 없는가?
        for(Integer sample : num){
            if(Collections.frequency(num,sample) >1){ //만약 List에 대한 값이 2개 이상이라면 중복으로 간주
                return false;
            }
        }
        return true;
    }
    private boolean isNumOnly(String num){ //숫자로만 이루어져있는가?
        try {
            Integer.parseInt(num);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
