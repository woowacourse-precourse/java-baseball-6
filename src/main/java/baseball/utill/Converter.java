package baseball.utill;

import java.util.ArrayList;
import java.util.List;

public class Converter {


    public static List<Integer> convertToNumericList(List<String> stringList){
        List<Integer> integerList = new ArrayList<>();

        for(String number: stringList){
            integerList.add(convertToNumeric(number));
        }
        return integerList;
    }
    private static int convertToNumeric(String number){

        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw  new IllegalArgumentException();
        }
    }

}
