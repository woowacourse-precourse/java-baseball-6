package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class FunctionTest {

    @Test
    void 컴퓨터정답_생성기능_테스트() {
        NumberController numberController = new NumberController();
        System.out.println(numberController.generateComputerNumberList());
    }

    @Test
    void 입력숫자_배열분리기능_테스트() {
        NumberController numberController = new NumberController();
        System.out.println(numberController.splitter(125));
    }

    @Test
    void 숫자배열_비교기능_테스트() {
        NumberController numberController = new NumberController();
        List<Integer> numList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(7, 1, 1));

        System.out.println(numberController.compareNumberList(numList1, numList2).get("strike"));
        System.out.println(numberController.compareNumberList(numList1, numList2).get("ball"));
    }

    @Test
    void 입력숫자_유효성검사기능_테스트() {
        ExceptionController exceptionController = new ExceptionController();

        exceptionController.validateThreeDigitNumber(99);
        exceptionController.validateGameProgressNumber(5);
    }

}
