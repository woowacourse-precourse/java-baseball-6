package baseball.contoller;

import baseball.controller.ValidUserNum;
import baseball.controller.ValidUserNumImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ValidUserNumTest {

    @Test
    void 유효한_유저_넘버_입력(){
        String s="123";
        ValidUserNum validUserNumImpl =new ValidUserNumImpl();

        List<Integer> testNum=new ArrayList<>(List.of(1, 2, 3));
        Assertions.assertThat(validUserNumImpl.getValidUserNum(s).getUserNumArray()).isEqualTo(testNum);


        String s2="458";

        List<Integer> testNum2=new ArrayList<>(List.of(4,5,8));
        Assertions.assertThat(validUserNumImpl.getValidUserNum(s2).getUserNumArray()).isEqualTo(testNum2);
    }

    @Test
    void 유효하지_않은_유저_넘버_입력(){

        ValidUserNum validUserNumImpl =new ValidUserNumImpl();
        // 길이가 3이 아닐때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("1234");
                }
                );

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("12");
                }
        );

        // 자연수 아닌 수가 들어갈때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("1.4");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("104");
                }
        );

        // 중복된 수가 들어갈 때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("114");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("141");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            validUserNumImpl.getValidUserNum("411");
                }
        );
    }

}
