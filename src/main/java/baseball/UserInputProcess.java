package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputProcess {
    List<Integer> listUserFixed;

    public UserInputProcess() {
        System.out.print("숫자를 입력해주세요 : ");
        UserInput users = new UserInput();
        this.listUserFixed = new ArrayList<>(users.changeCharToIntInList());
        int listUserFixedNum = listUserFixed.size();
        if (listUserFixedNum != 3) {
            throw new IllegalArgumentException();
        }

    }
    public List<Integer> listUserFixedReturn(){
        List list = this.listUserFixed;
        return  list;
    }

}
