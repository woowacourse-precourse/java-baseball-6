package baseball;

public class Input {
    User user = new User();
    Text text = new Text();

    public void userNum() {
        text.inputNum();
        user.getNum();
    }

    public boolean restartOrEndOption() {
        text.restartOrEnd();
        int optionNum = user.getOptionNum();
        return user.option(optionNum);
    }
}
