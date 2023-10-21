package baseball.refree;

import baseball.computer.Computer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RefreeTest {
    @Test
    void 판정_카운트_볼() {
        Refree count = new Refree();
        Computer computer = new Computer();

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        p1.add(1);
        p1.add(2);
        p1.add(3);

        p2.add(2);
        p2.add(3);
        p2.add(1);

        System.out.println(count.count(p1,p2));
    }

    @Test
    void 판정_카운트_스트라이크() {
        Refree count = new Refree();
        Computer computer = new Computer();

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        p1.add(1);
        p1.add(2);
        p1.add(3);

        p2.add(1);
        p2.add(2);
        p2.add(3);

        System.out.println(count.count(p1,p2));
    }

    @Test
    void 판정_카운트_볼_스트라이크() {
        Refree count = new Refree();
        Computer computer = new Computer();

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        p1.add(1);
        p1.add(2);
        p1.add(3);

        p2.add(1);
        p2.add(3);
        p2.add(2);

        System.out.println(count.count(p1,p2));
    }
}
