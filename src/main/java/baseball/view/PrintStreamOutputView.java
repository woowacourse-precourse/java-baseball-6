package baseball.view;

public class PrintStreamOutputView implements Output{

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
