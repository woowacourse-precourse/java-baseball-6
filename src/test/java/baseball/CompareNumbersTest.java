package baseball;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompareNumbersTest {
    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_전혀_없으면_낫싱을_리턴한다() {
        ComNumber comNumber = new ComNumber();
        comNumber.pickedNumbers = new ArrayList<>();
        comNumber.pickedNumbers.add(1);
        comNumber.pickedNumbers.add(2);
        comNumber.pickedNumbers.add(3);
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.inputNumbers = new ArrayList<>();
        playerNumber.inputNumbers.add(4);
        playerNumber.inputNumbers.add(5);
        playerNumber.inputNumbers.add(6);
        CompareNumbers compareNumbers = new CompareNumbers();
        String actual = compareNumbers.compare(comNumber, playerNumber);
        Assertions.assertEquals("낫싱", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_다른_자리에_있으면_볼을_리턴한다() {
        ComNumber comNumber = new ComNumber();
        comNumber.pickedNumbers = new ArrayList<>();
        comNumber.pickedNumbers.add(1);
        comNumber.pickedNumbers.add(2);
        comNumber.pickedNumbers.add(3);
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.inputNumbers = new ArrayList<>();
        playerNumber.inputNumbers.add(2);
        playerNumber.inputNumbers.add(5);
        playerNumber.inputNumbers.add(6);
        CompareNumbers compareNumbers = new CompareNumbers();
        String actual = compareNumbers.compare(comNumber, playerNumber);
        Assertions.assertEquals("1볼", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_같은_자리에_있으면_스트라이크를_리턴한다() {
        ComNumber comNumber = new ComNumber();
        comNumber.pickedNumbers = new ArrayList<>();
        comNumber.pickedNumbers.add(1);
        comNumber.pickedNumbers.add(2);
        comNumber.pickedNumbers.add(3);
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.inputNumbers = new ArrayList<>();
        playerNumber.inputNumbers.add(4);
        playerNumber.inputNumbers.add(2);
        playerNumber.inputNumbers.add(6);
        CompareNumbers compareNumbers = new CompareNumbers();
        String actual = compareNumbers.compare(comNumber, playerNumber);
        Assertions.assertEquals("1스트라이크", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_다른_자리에_있고_같은_수가_같은_자리에도_있으면_볼과_스트라이크를_리턴한다() {
        ComNumber comNumber = new ComNumber();
        comNumber.pickedNumbers = new ArrayList<>();
        comNumber.pickedNumbers.add(1);
        comNumber.pickedNumbers.add(2);
        comNumber.pickedNumbers.add(3);
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.inputNumbers = new ArrayList<>();
        playerNumber.inputNumbers.add(3);
        playerNumber.inputNumbers.add(2);
        playerNumber.inputNumbers.add(6);
        CompareNumbers compareNumbers = new CompareNumbers();
        String actual = compareNumbers.compare(comNumber, playerNumber);
        Assertions.assertEquals("1볼 1스트라이크", actual);
    }

}