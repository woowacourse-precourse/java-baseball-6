package baseball;

public class Strike {
    private int num = 0;

    private static Strike instance = new Strike();

    private Strike() {

    }

    public static Strike getInstance() {
        return instance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
