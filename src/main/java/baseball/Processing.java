package baseball;

import java.util.ArrayList;
import java.util.List;

public class Processing {

    public Processing() {
    }

    public List<Integer> convertStringToInteger(String inputValue){
        List<Integer> integerList = new ArrayList<>();
        String[] inputValueArray = inputValue.split(""); // 문자열 분리 후 배열에 삽입
        for (int i = 0; i < inputValue.length(); i++){
            integerList.add(Integer.valueOf(inputValueArray[i]));
        }
        return integerList;
    }
}
