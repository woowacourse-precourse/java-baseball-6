package baseball;

public class ResultMsgView {
    public void printGameResultMsg(int ballCount, int strikeCount) {
        ResultMsgSelector resultMsgSelector = new ResultMsgSelector();
        String resultMsg = resultMsgSelector.selectResultMsg(ballCount, strikeCount);
        System.out.println(resultMsg);
    }
}
