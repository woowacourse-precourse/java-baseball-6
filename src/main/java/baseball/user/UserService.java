package baseball.user;

import java.util.List;

public class UserService {
    private boolean isNotDuplicatedList (List<Integer> numbers){
        int listLength = (int)numbers.stream().
                distinct().count();

        if(listLength == numbers.size()){
            return true;
        }

        return false;
    }

    public boolean isInputRight(List<Integer> numbers){
        if(isNotDuplicatedList(numbers) && numbers.size()==3){
            return true;
        }
        return false;
    }


}
