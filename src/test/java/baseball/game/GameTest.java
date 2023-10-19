package baseball.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    Game game = new Game();

    @Test
    void errorValidateTest() throws NoSuchMethodException {
        //given
        Method errorValidate = Game.class.getDeclaredMethod("errorValidate", String.class);
        errorValidate.setAccessible(true);
        String number1 = "aaa";

        //then
        //리플렉션에서 메서드 예외 발생시 InvocationTargetException으로 래핑해서 반환
        assertThrows(InvocationTargetException.class,()->errorValidate.invoke(game,number1));
    }

    @Test
    void stringToIntegerListTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Method stringToIntegerList = Game.class.getDeclaredMethod("stringToIntegerList", String.class);
        stringToIntegerList.setAccessible(true);
        String number = "753";
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(3);

        //when
        List<Integer> invoke = (List<Integer>)stringToIntegerList.invoke(game, number);

        //then
        assertEquals(invoke,list);
    }

}