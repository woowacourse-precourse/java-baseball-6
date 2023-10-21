package util.convertor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConvertor {
            public static List<Integer> convert(String number){
                return number.chars()
                        .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
