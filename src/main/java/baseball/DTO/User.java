package baseball.DTO;

import javax.swing.text.TableView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    List<Integer> userNumbers;

    public User(String inputNumbers){
        userNumbers = parseStringToInteger(inputNumbers);
        checkSize(inputNumbers);
        checkDuplicate(userNumbers);
        checkRange(userNumbers);
    }
    public void checkSize(String inputNumbers){
        if (inputNumbers.length() != 3){
            throw new IllegalStateException("3자리 숫자여야 합니다.");
        }
    }
    public void checkRange(List<Integer> userNumbers){
        if(!userNumbers.stream().allMatch(c -> c > 0 && c < 10)){
            throw new IllegalStateException("1~9사이 숫자여야 합니다.");
        }
    }
    public void checkDuplicate(List<Integer> userNumbers){
        Set<Integer> userNumberSet = new HashSet<>(userNumbers);
        if (userNumbers.size() != userNumberSet.size()){
            throw new IllegalStateException("중복된 숫자가 있습니다.");
        }
    }
    public List<Integer> parseStringToInteger(String inputNumbers){
        return Arrays.stream(inputNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
