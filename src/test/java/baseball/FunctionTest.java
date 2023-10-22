package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;



public class FunctionTest {
  @Test
  void NumberGeneratorTest() {
    NumberController numberController = new NumberController();
    System.out.println(numberController.generate());
  }
  @Test
  void NumberSplitterTest() {
    NumberController numberController = new NumberController();
    System.out.println(numberController.splitter(125));
  }
  @Test
  void CompareNumberListTest() {
    NumberController numberController = new NumberController();
    List<Integer> numList1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
    List<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(7,1,1));

    System.out.println(numberController.compareNumberList(numList1, numList2).get("strike"));
    System.out.println(numberController.compareNumberList(numList1, numList2).get("ball"));
  }

}
