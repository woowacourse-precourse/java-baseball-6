package baseball.contoller;

import baseball.controller.ValidUserNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ValidUserNumTest {

    @Test
    void 유효한_유저_넘버_입력(){
        String s="123";
        ValidUserNum validUserNum=new ValidUserNum(s);

        List<Integer> testNum=new ArrayList<>(List.of(1, 2, 3));
        Assertions.assertThat(validUserNum.getUserNum().getUserNumArray()).isEqualTo(testNum);


        String s2="458";
        ValidUserNum validUserNum2=new ValidUserNum(s);

        List<Integer> testNum2=new ArrayList<>(List.of(4,5,8));
        Assertions.assertThat(validUserNum.getUserNum().getUserNumArray()).isEqualTo(testNum);
    }

    @Test
    void 유효하지_않은_유저_넘버_입력(){

        // 길이가 3이 아닐때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
            new ValidUserNum("1234");
                }
                );

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("12");
                }
        );

        // 자연수 아닌 수가 들어갈때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("1.4");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("104");
                }
        );

        // 중복된 수가 들어갈 때
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("114");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("141");
                }
        );
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,()->{
                    new ValidUserNum("411");
                }
        );
    }

}
