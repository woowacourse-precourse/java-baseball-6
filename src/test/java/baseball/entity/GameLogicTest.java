package baseball.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
    @Test
    void 컴퓨터의_숫자와_플레이어의_숫자가_같으면_Map의_strike_value가_3(){
        GameLogic gameLogic = new GameLogic();
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        Map<String, Integer> result = gameLogic.compareNumbers(playerNumbers, computerNumbers);

        assertEquals(3, result.get("strike"));
    }

    @Test
    void 컴퓨터의_숫자와_플레이어의_숫자가_자릿수는_다르고_숫자가_하나만_일치면_Map의_strike_value가_0_balls_value_1(){
        GameLogic gameLogic = new GameLogic();
        List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(3,2,4));
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(2,1,5));
        Map<String, Integer> result = gameLogic.compareNumbers(playerNumbers, computerNumbers);

        assertEquals(0, result.get("strike"));
        assertEquals(1, result.get("balls"));
    }

}