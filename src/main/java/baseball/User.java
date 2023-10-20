package baseball;

public class User {
    private static final int MAX_RANGE_OF_NUM = 57;//ASCII 9
    private static final int MIN_RANGE_OF_NUM = 49;//ASCII 1
    private char[] selectUser;
    public User(char[] selectUser) {
        isValid(selectUser);
        System.out.println(selectUser);
        this.selectUser = selectUser;
    }

    private void isValid(char[] selectUser) {
        validateSelectNum(selectUser);
    }

    private void validateSelectNum(char[] selectUser) {
        for (int i = 0; i < 3; i++) {
            if((selectUser.length > 3) || !((MIN_RANGE_OF_NUM <= selectUser[i]) && (selectUser[i] <= MAX_RANGE_OF_NUM))) {//is not int Array
                System.out.println("잘못잘못!");
                throw new IllegalArgumentException("Invalid argument: " + selectUser[i]);
            }
        }
    }

    public char[] getterSelectUserNum() {
        return selectUser;
    }
}
