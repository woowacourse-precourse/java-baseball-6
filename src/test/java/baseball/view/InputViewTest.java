package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputViewTest extends NsTest {
    @Test
    public void testNumberInput() {
        run("123");
        InputView inputView = new InputView();
        ArrayList<Integer> result = inputView.numberInput();
        ArrayList<Integer> expected = new ArrayList<>(List.of(1,2,3));
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidNumberInput() {
        run("1234");
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, inputView::numberInput);
    }

    @Test
    public void testInvalidInputFormat() {
        run("abc");
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, inputView::numberInput);
    }

    @Test
    public void testInvalidInputOverlap() {
        run("112");
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, inputView::numberInput);
    }

    @Test
    public void testRestartInput() {
        run("1");
        InputView inputView = new InputView();
        int result = inputView.restartInput();
        assertEquals(1, result);
    }

    @Test
    public void testInvalidRestartInput() {
        run("3");
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, inputView::restartInput);
    }

    @Override
    protected void runMain() {
    }
}
