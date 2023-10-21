package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ClientNumbers {

    public final List<Integer> intArr;

    public ClientNumbers(int size) {
        intArr = new ArrayList<>(size);
    }
}
