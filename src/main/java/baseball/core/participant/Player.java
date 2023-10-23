package baseball.core.participant;

import baseball.core.NumberPicker;
import java.util.ArrayList;
import java.util.List;

public class Player implements Participant {

    private final NumberPicker numberPicker;

    protected Player(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public static Player createPlayer(NumberPicker numberPicker) {
        return new Player(numberPicker);
    }

    @Override
    public List<Integer> pickNumber(String rawData) {
        List<Integer> originList = numberPicker.picConsoleNumber(rawData);
        return new ArrayList<>(originList);
    }


}
