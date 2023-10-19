package baseball.validation;
import baseball.constant.MessageConstant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberValidation {

    public void validateInputNumber(String inputNumber){
        List<Integer>userNumber = changeToList(inputNumber);
        validateNumberSize(userNumber);

    }

    public List<Integer> changeToList(String inputNumber){
        List<Integer> userNumber = Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return userNumber;
    }

    public void validateNumberSize(List<Integer> userNumber){
        if(userNumber.size() != 3){
            throw new IllegalArgumentException(MessageConstant.VALIDATE_SIZE_MESSAGE);
        }
    }

}
