package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void match() {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> brr = new ArrayList<>();
        String answer = "1볼 1스트라이크";

        arr.add(1);
        arr.add(2);
        arr.add(3);

        brr.add(2);
        brr.add(4);
        brr.add(3);

        BaseballResultState result = BaseballGame.match(arr, brr);
        assertEquals(result.toString(), answer);
    }
}