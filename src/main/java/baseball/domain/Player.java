package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<BaseballGameNumbers> pickList;

    public Player(){
        this.pickList = new ArrayList<>();
    }

    public void pickNumber(BaseballGameNumbers numbers){
        this.pickList.add(numbers);
    }

    public List<BaseballGameNumbers> getPickList(){
        return this.pickList;
    }

    public BaseballGameNumbers getLastPick() {
        if (isEmpty())
            return null;

        return this.pickList.get(this.pickList.size() - 1);
    }

    private boolean isEmpty() {
        return this.pickList.isEmpty();
    }
}
