package baseball;

public interface LanguagePack {
    String renderGameStartMsg();
    String renderHintMsg(Result result);
    String renderVictoryMsg();
    String renderGameEndMsg();
    String renderAskNewGameMsg();
    String renderAskNumbersMsg();
}
