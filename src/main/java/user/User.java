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
        convertToInteger(userNumber);
        return new Balls(userNumberList);
    }

    public List<Integer> convertToInteger(String strNumber){
            return strNumber.chars()
                    .boxed()
                    .collect(Collectors.toList());

        //기존의 리스트에는 유저가 입력한 숫자의 반대로 추가되었으므로 다시 그 순서를 뒤집는다.
        //Collections.reverse(userNumberList);
    }

    //public List<String> StringToStringList(String strNumber){

    //}
}
