package baseball.Parse;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class ParseServiceImpl implements ParseService{
    @Override
    public List<Integer> stringParseToNumbers(String StringNumbers) {
        if(StringNumbers.length() != SIZE)
            throw new IllegalArgumentException();

        List<Integer> numbers = new ArrayList<>();
        for(String string : StringNumbers.split("")){
            numbers.add(Integer.parseInt(string));
        }
        return numbers;
    }

    @Override
    public boolean isRestart(String flag) {
        if (flag.equals(RESTART_FLAG))
            return true;
        if (flag.equals(END_FLAG))
            return false;
        throw new IllegalArgumentException();
    }
}
