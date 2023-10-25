package baseball.core.participant;

import baseball.core.NumberPicker;
import java.util.ArrayList;
import java.util.List;

public class Opponent implements Participant {

    private final NumberPicker numberPicker;

    protected Opponent(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public static Opponent createOpponent(NumberPicker numberPicker) {
        return new Opponent(numberPicker);
    }

    @Override
    public List<Integer> pickNumber() {
        List<Integer> originList = numberPicker.pickRandomNumber();
        return new ArrayList<>(originList);
    }

}
