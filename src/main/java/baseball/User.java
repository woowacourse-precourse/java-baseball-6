package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class User{

    private List<Integer> user = new ArrayList<>();

    public void setUser() throws IllegalArgumentException{

       int num = Integer.parseInt(Console.readLine());
        int first = num/100;
        int second = (num%100)/10;
        int last  = num %10;
        num = checkError(num,first,second,last);
        user.add(first);
        user.add(second);
        user.add(last);

    }

    public void clearUser(){
        user.clear();
    }

    List<Integer> getUser(){
        return user;
    }

    public int checkError(int num,int first, int second, int last) throws IllegalArgumentException{
        if(num<100 || num >1000 || first == second  || second == last || first == last){
            throw new IllegalArgumentException();
        }
        return num;
    }

}
