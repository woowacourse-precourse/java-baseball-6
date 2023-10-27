package parsing;

import java.util.List;
import java.util.stream.*;

public class NumberParsing {
    public static List <Integer> makeNumbersFromString(String numberString){
        return numberString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}