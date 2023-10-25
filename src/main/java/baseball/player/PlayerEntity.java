package baseball.player;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerEntity {

    protected List<Integer> numberList = new ArrayList<>();

    public void emptyList(){
        numberList.clear();
    }

    // list getter
    public List<Integer> getNumberList() {
        return numberList;
    }

    // list setter
    public abstract void setNumberList(List<Integer> numberList);

}
