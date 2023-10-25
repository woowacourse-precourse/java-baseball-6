package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomViewTest {

    @Test
    public void strToListTest(){
        String input = "123";
        CustomView customView = new CustomView();

        List<Integer> result = customView.strToList(input);

        assertEquals(Arrays.asList(1, 2, 3), result);

    }
}
