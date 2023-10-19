package baseball.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printHint() {
        //given
        OutputView outputView = new OutputView();
        //when
        outputView.printHint(2,3);
        outputView.printHint(0,3);
        outputView.printHint(0,0);
        //then

    }
}