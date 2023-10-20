package baseball;
import java.util.Arrays;

public class User {
    private int[] selectUsers;
    public void selectUserNum(String input) {
        this.selectUsers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        validateSelectNum();
    }

    private void validateSelectNum() {
        for (int i = 0; i < 4; i++) {
            if((i == 3) || !(Character.isDigit(selectUsers[i]))) {//is not int Array
                throw new IllegalArgumentException("Invalid argument: " +  + selectUsers[i]);
            }
        }
    }

    public int[] getterSelectUserNum() {
        return selectUsers;
    }
}
