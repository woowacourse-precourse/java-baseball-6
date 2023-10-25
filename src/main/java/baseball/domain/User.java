package baseball.domain;

public class User {
    int[] userNumList;

    public User() {
    }

    public User(int[] userNumList) {
        this.userNumList = userNumList;
    }

    public int[] getUserNumList() {
        return userNumList;
    }

    public void setUserNumList(int[] userNumList) {
        this.userNumList = userNumList;
    }
}
