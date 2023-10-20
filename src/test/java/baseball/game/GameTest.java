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
        String number1 = "111";
        String number2 = "121";
        String number3 = "211";


        //then
        //리플렉션에서 메서드 예외 발생시 InvocationTargetException으로 래핑해서 반환
        assertThrows(InvocationTargetException.class,()->errorValidate.invoke(game,number1));
        assertThrows(InvocationTargetException.class,()->errorValidate.invoke(game,number2));
        assertThrows(InvocationTargetException.class,()->errorValidate.invoke(game,number3));
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

    @Test
    void inputCheckTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        //given
        game.randomNumber.add(7);
        game.randomNumber.add(5);
        game.randomNumber.add(3);

        Method inputCheck = Game.class.getDeclaredMethod("inputCheck", List.class);
        inputCheck.setAccessible(true);
        List<Integer> list1 = new ArrayList<>(); //3strike , false
        list1.add(7);
        list1.add(5);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>(); //2ball 1strike , true
        list2.add(7);
        list2.add(3);
        list2.add(5);

        List<Integer> list3 = new ArrayList<>(); //nothing , true
        list3.add(2);
        list3.add(4);
        list3.add(6);

        //when
        boolean invoke1 = (boolean)inputCheck.invoke(game, list1);
        boolean invoke2 = (boolean)inputCheck.invoke(game, list2);
        boolean invoke3 = (boolean)inputCheck.invoke(game, list3);


        //then
        assertFalse(invoke1);
        assertTrue(invoke2);
        assertTrue(invoke3);
    }

    @Test
    void restartOrExitCheckTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Method restartOrExitCheck = Game.class.getDeclaredMethod("restartOrExitCheck", String.class);
        restartOrExitCheck.setAccessible(true);
        String restart = "1"; //true
        String exit = "2"; //false
        String error = "3"; //error

        //when
        boolean invoke1 = (boolean)restartOrExitCheck.invoke(game, restart);
        boolean invoke2 = (boolean)restartOrExitCheck.invoke(game, exit);

        assertTrue(invoke1);
        assertFalse(invoke2);
        assertThrows(InvocationTargetException.class , ()->restartOrExitCheck.invoke(game,error));


    }

}