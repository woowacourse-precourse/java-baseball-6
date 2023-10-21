//package baseball;
//
//import baseball.controller.BaseBallGame;
//import baseball.utils.Validator;
//import baseball.view.InputView;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//class BaseBallGameTest {
//
//    @Test
//    void isNotIntegerType(){
//        Validator validator = new Validator();
//        boolean isNotInteger = false;
//
//        assertThat(validator.isNotIntegerType("123"))
//                .isEqualTo(isNotInteger);
//    }
//
//    @Test
//    void splitStringToDigits(){
//        InputView inputView = new InputView();
//        List<Integer> integerList = inputView.splitStringToDigits("123");
//
//        ArrayList<Integer> digitList = new ArrayList<>(Arrays.asList(1,2,3));
//        assertThat(digitList).isEqualTo(integerList);
//    }
//
//    @Test
//    void isDuplicateNumber(){
//    Validator validator = new Validator();
//        boolean duplicateFlag = true;
//
//        assertThat(validator.isDuplicateNumber("122"))
//                .isEqualTo(duplicateFlag);
//    }
//
//    @Test
//    void isNotCorrectButton(){
//        BaseBallGame baseBallGame = new BaseBallGame();
//        boolean buttonCheck = true;
//
//        assertThat(baseBallGame.isNotCorrectButton("3"))
//                .isEqualTo(buttonCheck);
//    }
//}