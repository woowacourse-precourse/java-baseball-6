package baseball;

import baseball.game.displayboard.DisplayBoard;
import baseball.game.displayboard.DisplayBoardImpl;
import baseball.game.gamesetter.GameSetting;
import baseball.game.gamesetter.GameSettingImpl;
import baseball.game.hitter.Hitter;
import baseball.game.hitter.PlayerHitterImpl;
import baseball.game.pitcher.ComputerRandomPitcherImpl;
import baseball.game.pitcher.Pitcher;
import baseball.game.umpire.ComputerUmpireImpl;
import baseball.game.umpire.Umpire;

public class AppConfig {
    //Hitter Setting
    public static final int DIGIT_NUM = 3; //숫자 자릿수 설정
    public static final int MAX_NUMBER = 9; //최대 숫자 설정
    public static final int MIN_NUMBER = 1; //최소 숫자 설정
    public static final char MAX_CHAR = '9'; //최대 문자 설정
    public static final char MIN_CHAR = '1'; //최소 문자 설정

    public GameSetting gameSetting() { return new GameSettingImpl(); } //게임 진행 설정

    public Hitter hitter() {
        return new PlayerHitterImpl();
    } //타자 설정

    public Pitcher pitcher() {
        return new ComputerRandomPitcherImpl();
    } //투수 설정

    public Umpire umpire() {
        return new ComputerUmpireImpl();
    } //심판 설정

    public DisplayBoard displayBoard() { return new DisplayBoardImpl(); } //전광판(Console)출력 설정
}
