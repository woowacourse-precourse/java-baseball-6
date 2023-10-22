package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class User{

    private List<Integer> user = new ArrayList<>();

    void setUser() throws IllegalArgumentException{

        Integer num = Integer.parseInt(Console.readLine());
        user.add(num/100);
        user.add((num%100)/10);
        user.add(num%10);
    }

    void clearUser(){
        user.clear();
    }

    List<Integer> getUser(){
        return user;
    }

}
