package baseball.Model;

public class Count {
    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count += 1;
    }

    public void setCount(int count){
        this.count = count;
    }

    private int count;
}
