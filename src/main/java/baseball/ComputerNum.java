package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    int c1,c2,c3;

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC1() {
        return c1;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC2() {
        return c2;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC3() {
        return c3;
    }

    public void makeComputerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setC1(computer.get(0));
        setC2(computer.get(1));
        setC3(computer.get(2));
    }

    public void testComputerNum(int t1, int t2, int t3){
        setC1(t1);
        setC2(t2);
        setC3(t3);
    }
}
