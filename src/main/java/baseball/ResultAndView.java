package baseball;

public class ResultAndView {
    private String result;
    private boolean isContinue;

    public ResultAndView(String result, boolean isContinue) {
        this.result = result;
        this.isContinue = isContinue;
    }

    public String getResult() {
        return result;
    }

    public boolean getIsContinue() {
        return isContinue;
    }

    @Override
    public boolean equals(Object obj) {
        ResultAndView other = (ResultAndView) obj;
        return this.result.equals(other.result) && this.isContinue == other.isContinue;
    }

    @Override
    public String toString() {
        return "result: " + result + ", isContinue: " + isContinue;
    }
}
