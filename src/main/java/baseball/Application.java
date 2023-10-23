package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        if(input.length() != 3){
            System.exit(0);
        }
        List<Integer> userNumberList = new ArrayList<Integer>();
        Set<Integer> userNumberSet = new HashSet<Integer>();
        for(int i = 0; i < input.length(); i++){
            if(!('1' <= input.charAt(i) && input.charAt(i) <= '9')){
                System.exit(0);
            }
            else{
                userNumberList.add((int) input.charAt(i));
                userNumberSet.add((int) input.charAt(i));
            }
        }
        if(userNumberSet.size() != userNumberList.size()){
            System.exit(0);
        }
    }
}
