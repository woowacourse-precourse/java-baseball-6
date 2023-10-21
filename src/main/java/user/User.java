package user;

import baseball.Balls;
import baseball.BaseBallGame;
import baseball.Game;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class User {

    private static final int INIT_NUMBER=0;
    private static final int BALLS_SIZE=3;
    private static final int DIVISOR=10;
    private List userNumberList=new ArrayList<>();


    private void initList(){
        userNumberList.clear();
    }

    public Balls makeUserNumber(){
        initList();
        System.out.println("숫자를 입력해주세요: ");
        String strNumber= Console.readLine();
        translateStringToList(strNumber);
        return new Balls(userNumberList);
    }

    public void translateStringToList(String strNumber){

        int intNumber=Integer.parseInt(strNumber);
        for(int cur=INIT_NUMBER; cur<strNumber.length();cur++){
            userNumberList.add(intNumber%DIVISOR);
            intNumber=intNumber/DIVISOR;
        }
        //기존의 리스트에는 유저가 입력한 숫자의 반대로 추가되었으므로 다시 그 순서를 뒤집는다.
        Collections.reverse(userNumberList);


    }
}
