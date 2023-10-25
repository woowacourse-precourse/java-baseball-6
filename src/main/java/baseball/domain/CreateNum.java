package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;


public class CreateNum {
    private String createNum;

    public CreateNum(){
        setInitialReturnNum();
    }

    public void setInitialReturnNum(){
        LinkedHashSet<String> createNumberSetting = new LinkedHashSet<>();
        while (createNumberSetting.size() < 3){
            createNumberSetting.add(getRanNum());
        }
        this.createNum = String.join("",createNumberSetting);
    }

    public static String getRanNum(){
        return Integer.toString(Randoms.pickNumberInRange(1,9));
    }

    public String getCreateNum() {
        return createNum;
    }
}