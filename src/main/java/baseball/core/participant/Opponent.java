package baseball.core.participant;

import baseball.Enum.ParticipantEnum;
import baseball.core.NumberPicker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Opponent implements Participant {

    private final NumberPicker numberPicker;

    public Opponent(NumberPicker numberPicker) {
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
