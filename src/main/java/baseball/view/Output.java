package baseball.view;

public class Output {
    private static Output output = new Output();

    private Output() {}

    public static Output getOutput() {
        return output;
    }

    public void announceMention(String mention) {
        System.out.print(mention);
    }
}
