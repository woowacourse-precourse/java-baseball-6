package baseball.domain.baseballplayer.dto;

import java.util.Collections;
import java.util.List;

public record Ball(List<Integer> numbers) {

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

}
