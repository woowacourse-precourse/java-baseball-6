package baseball.model;

public enum UserAction {
    CONTINUE(1),
    FINISH(2);

    private int value;

    private UserAction(int value){
        this.value = value;
    }

    public static UserAction valueOf(int value){
        for (UserAction userAction : values()){
            if (userAction.value == value) return userAction;
        }

        throw new IllegalArgumentException("1, 2 입력값만 유효함");
    }
}
