package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class InputGameNumberTest {


    @Test
    @DisplayName("사용자의 숫자 입력이 정상적으로 들어오는지 테스트")
    void 숫자입력_테스트(){
        //given
        InputGameNumber inputGameNumber = new InputGameNumber();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> expected = List.of(1,2,3);
        //when
        List<Integer> result = inputGameNumber.inputNum();
        //then
        Assertions.assertEquals(expected, result);
    }
}
