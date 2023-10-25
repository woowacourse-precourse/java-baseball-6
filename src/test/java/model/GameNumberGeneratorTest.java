package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GameNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자가 세 개가 맞는지 확인")
    void 컴퓨터숫자_개수(){
        //given
        GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
        //when
        List<Integer> gameNumber = gameNumberGenerator.createNum();
        //then
        assertEquals(3, gameNumber.size());
    }

    @Test
    @DisplayName("생성된 숫자가 각각 다른 숫자인지 확인")
    void 중복숫자_확인(){
        //given
        GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
        //when
        List<Integer> gameNumber = gameNumberGenerator.createNum();
        //then
        Set<Integer> numberSet = new HashSet<>(gameNumber);
        assertEquals(gameNumber.size(), numberSet.size());
//        assertTrue(numberSet.size() == gameNumber.size()); //이렇게도 가능
    }

    @Test
    @DisplayName("생성된 숫자가 1~9사이의 숫자인지 확인")
    void 숫자범위_확인(){
        //given
        GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
        //when
        List<Integer> gameNumber = gameNumberGenerator.createNum();
        //then
        assertTrue(gameNumber.stream().allMatch(number -> number >= 1 && number <= 9));
    }
}
