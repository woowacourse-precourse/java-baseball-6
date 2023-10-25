package baseball;

public class User {
    private static final User instance = new User();
    private static final int SIZE = 3;
    private static final int[] arr = new int[SIZE];
    private User() {}
    public static User getInstance() {
        return instance;
    }

    public int[] setUserNums(String str) {
        boolean check = validArgs(str);

        if (check) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < str.length(); i++) {
                int d = str.charAt(i) - '0';
                arr[i] = d;
            }
        }
        return arr;
    }

    private boolean validArgs(String str) {
        boolean b = false;

        if (str.length() > SIZE) {
            throw new IllegalArgumentException();
        }
        if (str.contains(" ")) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (49 > c || c > 57) {
                b = true;
                break;
            }
        }
        return b;
    }

}
