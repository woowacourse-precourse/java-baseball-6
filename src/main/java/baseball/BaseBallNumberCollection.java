package baseball;

import java.util.List;
import java.util.Set;

public class BaseBallNumberCollection {
    private final List<Integer> randomNumberList;

    public static final Integer NOT_FOUND = -1;

    public BaseBallNumberCollection(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public Integer indexOf(Integer number){
        if(randomNumberList.contains(number)){
            return randomNumberList.indexOf(number);
        }
        return NOT_FOUND;
    }

    public Integer get(int index){
        return randomNumberList.get(index);
    }

    public Integer size(){
        return randomNumberList.size();
    }

    public Set<Integer> getUniqueValueSet(){
        return Set.copyOf(this.randomNumberList);
    }

}
