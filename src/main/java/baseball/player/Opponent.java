package baseball.player;
import java.util.List;

public class Opponent extends PlayerEntity {
    @Override
    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
