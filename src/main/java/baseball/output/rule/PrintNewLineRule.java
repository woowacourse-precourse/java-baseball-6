package baseball.output.rule;

public class PrintNewLineRule implements PrintBaseBallResultOutputRule {
    public PrintNewLineRule() {
        // Empty
    }

    @Override
    public void print() {
        System.out.println();
    }
}
