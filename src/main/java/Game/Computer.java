package Game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public Computer(){
        this.list = new ArrayList<>();
        init();
    }

    void init(){
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
    }

    @Override
    public String toString() {
        String info = "Computer: ";
        for (int i = 0; i < list.size(); i++){
            info += list.get(i) + " ";
        }
        return info;
    }
}
