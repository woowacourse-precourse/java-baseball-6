package baseball;

public class KoreanLanguagePack implements LanguagePack {
    private static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.\n";
    private static final String VICTORY_MSG = "%d개의 숫자를 모두 맞히셨습니다! ";
    private static final String GAME_END_MSG = "게임 종료\n";
    private static final String BULL = "%d스트라이크";
    private static final String COW = "%d볼";
    private static final String NOTHING = "낫싱";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ASK_NEW_GAME = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    public String renderGameStartMsg() {
        return GAME_START_MSG;
    }

    public String renderHintMsg(Result result) {
        StringBuilder sb = new StringBuilder();
        if (result.cows > 0) {
            sb.append(String.format(COW, result.cows));
        }
        if (result.bulls > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(String.format(BULL, result.bulls));
        }
        if (sb.length() == 0) {
            sb.append(NOTHING);
        }
        sb.append('\n');
        return sb.toString();
    }

    public String renderVictoryMsg() {
        return String.format(VICTORY_MSG, SecretNumber.SIZE);
    }

    public String renderGameEndMsg() {
        return GAME_END_MSG;
    }

    public String renderAskNewGameMsg() {
        return String.format(ASK_NEW_GAME, "1", "2");
    }

    public String renderAskNumbersMsg() {
        return ASK_NUMBER;
    }
}
