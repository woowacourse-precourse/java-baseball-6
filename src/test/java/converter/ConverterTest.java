package converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ConverterTest {
    Converter converter = new Converter();
    @Test
    public void 문자열을_정수형_리스트로_변환_테스트(){
        //given
        String input="123";
        //when
        List<Integer> intList = converter.stringToIntList(input);
        //then
        for(int i=0; i<intList.size(); i++){
            int number =intList.get(i);
            Assertions.assertEquals(input.charAt(i),number);
        }
    }
    @Test
    public void 정수형_리스트를_문자열로_변환_테스트(){
        //given
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        //when
        String string = converter.intListToString(intList);
        //then
        Assertions.assertEquals("123",string);
    }


}
