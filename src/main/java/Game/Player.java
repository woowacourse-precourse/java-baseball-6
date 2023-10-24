package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> list;

    public Player(){
        this.list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String info = "Player: ";
        for (int i = 0; i < list.size(); i++){
            info += list.get(i) + " ";
        }
        return info;
    }
}
