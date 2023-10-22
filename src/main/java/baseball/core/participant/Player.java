package baseball.core.participant;

import baseball.Enum.ParticipantEnum;
import baseball.core.NumberPicker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Participant {

    private final NumberPicker numberPicker;

    public Player(NumberPicker numberPicker) {
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
