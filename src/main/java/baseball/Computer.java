package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Computer {
    public List<Integer> makecomputernumber(){
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> numbers = new ArrayList<>();
        while(set.size()<3){
            set.add(Randoms.pickNumberInRange(1,9));
        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            numbers.add(iter.next());
        }
        return numbers;
    }
}
