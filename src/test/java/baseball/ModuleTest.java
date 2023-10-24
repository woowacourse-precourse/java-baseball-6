package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModuleTest {

    @Test
    void checkResult() {
        List<Integer> a=List.of(1, 2, 3) ;
        List<Integer> b=List.of(4, 2, 1);

        Application.Result result = Application.checkResult(a, b);

        System.out.println(result);
    }
}