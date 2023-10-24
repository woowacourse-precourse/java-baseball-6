package baseball.domain;

import java.util.List;

public class User {
    private static List<Integer> user;
    private static int restart;

    public static List<Integer> getUser() {
        return user;
    }

    public static void setUser(List<Integer> user) {
        User.user = user;
    }

    public static int getRestart() {
        return restart;
    }

    public static void setRestart(int restart) {
        User.restart = restart;
    }
}
