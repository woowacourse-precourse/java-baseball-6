package baseball;

import baseball.check.Checknum;
import baseball.check.checkthreenum;
import baseball.distinguishnumber.Distinguish;
import baseball.distinguishnumber.distinguishNum;
import baseball.makerandomnumber.Randomgenerator;
import baseball.makerandomnumber.threerandommaker;

public class AppConfig {
    public Checknum checknum(){
        return new checkthreenum();
    }

    public Distinguish distinguish(){
        return new distinguishNum();
    }

    public Randomgenerator randomgenerator(){
        return new threerandommaker();
    }
}
