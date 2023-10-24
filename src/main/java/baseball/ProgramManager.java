package baseball;

public class ProgramManager {

    private Reader reader;
    private Writer writer;
    private Answer answer;
    private Validator validator;

    public ProgramManager() {
        reader = new Reader();
        writer = new Writer();
        answer = new Answer();
        validator = new Validator();
    }

}
