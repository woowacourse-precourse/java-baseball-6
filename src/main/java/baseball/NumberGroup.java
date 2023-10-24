package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class NumberGroup {
    private final List<Number> numbers;
    public NumberGroup(List<Number> numbers){
        Error.check_Numsize(numbers);
        Error.is_Duplicate(numbers);
        this.numbers = numbers;
    }

    public static NumberGroup user_num(String user_num_str){
        List<Number> user_num = new ArrayList<>();

        if(Error.is_Not_number(user_num_str)){
            throw new IllegalArgumentException("숫자를 입력해주세요..");
        }

        String[] token = user_num_str.split("");

        for(int i = 0 ; i<user_num_str.length() ; i++){
            Number num = new Number(Integer.parseInt(token[i]));
            user_num.add(num);
        }

        return new NumberGroup(user_num);
    }

    public static NumberGroup com_num(){
        List<Number> com_num = new ArrayList<>();

        for(int i = 0 ; com_num.size() < Constant.MAX_SIZE ; i++) {
            Number num = new Number(Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER));
            if(!com_num.contains(num)) {
                com_num.add(num);
            }
        }

        return new NumberGroup(com_num);
    }

    public Number get(int i) {
        return numbers.get(i);
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }
}
