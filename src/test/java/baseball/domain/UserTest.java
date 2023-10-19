package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {
/**
 * 아래는 private 메소드를 테스트하는 코드 였음.
 * 하지만 private 메소드는 테스트 하는 것이 아님을 깨달음.
 * public 메소드로 private 메소드 또한 검증하는 테스트를 해야함.
 */
    @Test
    void 유효하지_않은_입력(){
        //given
        User user = new User();

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("203");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("-203");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("-2asd3");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("303");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("em3");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("0.3");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserBasebsallNumber("233");
        });
    }

    @Test
    void 유효한_입력(){
        //given
        User user0 = new User();
        User user1 = new User();
        User user2 = new User();

        //when
        user0.setUserBasebsallNumber("213");
        user1.setUserBasebsallNumber("295");
        user2.setUserBasebsallNumber("492");

        // then
        Assertions.assertEquals(List.of(2,1,3), user0.getUserBasebsallNumber());
        Assertions.assertEquals(List.of(2,9,5), user1.getUserBasebsallNumber());
        Assertions.assertEquals(List.of(4,9,2), user2.getUserBasebsallNumber());

    }



//    @Test
//    void 입력길이가_3이_아닌_경우() {
//        //given
//        User user = new User();
//
//        //when,then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validateLength("2356");
//        });
//    }
//
//    @Test
//    void 입력길이가_3인_경우() {
//        //given
//        User user = new User();
//
//        //when,then
//        user.validateLength("235");
//
//    }
//
//    @Test
//    void 입력에_중복_값이_있는_경우(){
//        //given
//        User user = new User();
//
//        //when,then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validateDuplicated("233");
//        });
//    }
//
//    @Test
//    void 입력에_중복_값이_없는_경우(){
//        //given
//        User user = new User();
//
//        //when,then
//        user.validateDuplicated("1234567890");
//    }
//
////    @Test
////    void 입력에_0이_포함된_경우(){
////        //given
////        User user = new User();
////
////        //when,then
////        Assertions.assertThrows(IllegalArgumentException.class, () -> {
////            user.validateIncludedZreo("203");
////        });
////    }
////
////    @Test
////    void 입력에_0이_포함되지_않은_경우(){
////        //given
////        User user = new User();
////
////        //when,then
////        user.validateIncludedZreo("2333");
////    }
//
//    @Test
//    void 숫자가_아닌_것이_포함된_경우(){
//        //given
//        User user = new User();
//
//        //when,then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("-203");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("-2asd3");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("303");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("em3");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("0.3");
//        });
//    }
//
//    @Test
//    void 숫자만_포함된_경우(){
//        //given
//        User user = new User();
//
//        //when,then
//       Assertions.assertEquals(List.of(2,3,3),user.validtaeNumeric("233"));
//    }
//
//    @Test
//    void 유효한_입력(){
//        //given
//        User user = new User();
//
//        //when,then
//        Assertions.assertEquals(List.of(2,1,3),user.validateInput("213"));
//        Assertions.assertEquals(List.of(2,4,7),user.validateInput("247"));
//        Assertions.assertEquals(List.of(2,3,9),user.validateInput("239"));
//    }
//
//    @Test
//    void 유효하지_않은_입력(){
//        //given
//        User user = new User();
//
//        //when,then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("-203");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("-2asd3");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("303");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("em3");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validtaeNumeric("0.3");
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.validateDuplicated("233");
//        });
//    }
}