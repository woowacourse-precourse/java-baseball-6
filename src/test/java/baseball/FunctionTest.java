package baseball;

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

}
