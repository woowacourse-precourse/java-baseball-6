package baseball.IO;

public class ConsoleOutput implements Output{

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
