package service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallServiceTest {
    BaseBallService service = new BaseBallService();

    @Test
    public void testCalResult(){
        List<Integer> randVal = service.generateNumbers();
        int[] userInput = {1,2,3};
        List<String> result = service.calResult(userInput);

        assertTrue(result.contains("1스트라이크") || result.contains("낫싱"));
    }

}