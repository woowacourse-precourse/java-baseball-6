package baseball;

import baseball.check.Checknum;
import baseball.check.checkthreenum;
import baseball.data.Data;
import baseball.distinguishnumber.Distinguish;
import baseball.distinguishnumber.distinguishNum;
import baseball.gamebaseball.baseballgame;
import baseball.output.Output;

public class AppConfig {
    private final Data data = new Data();
    public Checknum checknum(){
        return new checkthreenum();
    }

    public Distinguish distinguish(){
        return new distinguishNum(this.data);
    }


    public Output output() {
        return new Output();
    }

    public baseballgame baseballgame() {
        return new baseballgame(distinguish(), checknum(), output(), this.data);
    }

}
