package baseball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class User {
    public List<Integer> saveinput(int input){
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        List<Integer> inputnumber = new ArrayList<>();
        if(input< 100 || input >999){
            throw new IllegalArgumentException();
        }
        set.add(input/100);
        set.add(input/10%10);
        set.add(input%10);
        if(set.size() != 3){
            throw new IllegalArgumentException();
        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            inputnumber.add(iter.next());
        }
        return inputnumber;
    }
}
