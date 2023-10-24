package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.LinkedHashSet;


public class ComputerNumber {

    private  String computerNumber; //멤버변수

    public ComputerNumber(){//setGameClearNumber로 초기화
        setGameClearNumber();
    }
    public String getComputerNumber(){//외부에서 computerNumber사용할 경우 값 가져오기
        return computerNumber;
    }


    public void setGameClearNumber(){//컴퓨터의 임의의 수 3자리 할당
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<String>();
        while(computerNumberCheck.size()<3){
            computerNumberCheck.add(getRandomNumber());
        }
        this.computerNumber = String.join("",computerNumberCheck);

    }

    public static String getRandomNumber(){//setGameClearNumber의 수 범위 정하기
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }
}
