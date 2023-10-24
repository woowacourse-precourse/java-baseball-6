package user;

import baseball.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public Balls makeUserNumber(String userNumber){
        return new Balls(convertToInteger(userNumber));
    }

    private List<Integer> convertToInteger(String strNumber){
        return strNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

}
