package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.constant.MessageConstant.*;
import static baseball.constant.NumberConstant.*;

public class Baseball {

    public void checkInputForNonBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MSG);
        }
    }
}
