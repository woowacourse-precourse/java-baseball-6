package baseball.application.converter;

import java.util.List;

public interface StringConverter {

    int toInt(String input);

    List<Integer> toIntList(String input);

}
