package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerListUtil {

    public static List<Integer> parseIntegerList(String string){
        List<Integer> integerList = new ArrayList<>();

        for (char character : string.toCharArray()){
            integerList.add(IntegerUtil.parseInteger(character));
        }

        return integerList;
    }

}
