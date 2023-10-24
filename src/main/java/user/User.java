package user;

import baseball.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private static final int INIT_INDEX = 0;
    private static final int DIVISOR = 10;

    private List userNumberList = new ArrayList<>();

    private void initList(){
        userNumberList.clear();
    }

    public Balls makeUserNumber(String userNumber){
        initList();

        return new Balls(convertToInteger(userNumber));
    }

    private List<Integer> convertToInteger(String strNumber){
        return strNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

}
