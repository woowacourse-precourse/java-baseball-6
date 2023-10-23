package baseball;

import java.util.ArrayList;
import java.util.List;
public class NumberGroup {
    private List<Number> numbers;
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
}
