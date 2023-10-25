package baseball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_전혀_없으면_낫싱을_리턴한다() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        Computer computer = new Computer(computerNumbers);
        Player player = new Player("456");

        String actual = computer.compare(player);
        Assertions.assertEquals("낫싱", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_다른_자리에_있으면_볼을_리턴한다() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        Computer computer = new Computer(computerNumbers);
        Player player = new Player("345");

        String actual = computer.compare(player);
        Assertions.assertEquals("1볼", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_같은_자리에_있으면_스트라이크를_리턴한다() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        Computer computer = new Computer(computerNumbers);
        Player player = new Player("145");

        String actual = computer.compare(player);
        Assertions.assertEquals("1스트라이크", actual);
    }

    @Test
    void 컴퓨터수와_플레이어수를_비교해_같은_수가_다른_자리에_있고_같은_수가_같은_자리에도_있으면_볼과_스트라이크를_리턴한다() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        Computer computer = new Computer(computerNumbers);
        Player player = new Player("324");

        String actual = computer.compare(player);
        Assertions.assertEquals("1볼 1스트라이크", actual);
    }

}