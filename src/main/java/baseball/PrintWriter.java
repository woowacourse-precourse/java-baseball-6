package baseball;

public class PrintWriter implements Writer{
    @Override
    public void write(String context) {
        System.out.println(context);
    }
}
