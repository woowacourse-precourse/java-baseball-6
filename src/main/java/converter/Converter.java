package converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> stringToIntList(String input){
        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            int split_number = input.charAt(i)-48;
            intList.add(split_number);
        }
        return intList;
    }
    public String intListToString(List input){
        String string = "";
        for(int i=0; i<input.size(); i++){
            String split_number = String.valueOf(input.get(i));
            string= string + split_number;
        }
        return string;
    }
}
