package baseball.contoller;

import baseball.controller.GenerateTargetNum;
import baseball.model.TargetNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GenerateTargetNumberTest {


    @Test
    void 타겟_넘버_생성(){
        GenerateTargetNum generateTargetNum=new GenerateTargetNum();
        TargetNum targetNum =generateTargetNum.getTargetNum();
        List<Integer> targetNumArray=targetNum.getTargetNumArray();

        System.out.println(targetNumArray);

        // size가 3인지
        Assertions.assertThat(targetNumArray.size()).isEqualTo(3);

        // 세자리 모두 자연수 숫자인지
        List<Integer> naturalNum=new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assertions.assertThat(naturalNum).containsAll(targetNumArray);

        // 각 자리의 숫자가 다른지
        Assertions.assertThat(targetNumArray.get(0)).isNotEqualTo(targetNumArray.get(1));
        Assertions.assertThat(targetNumArray.get(0)).isNotEqualTo(targetNumArray.get(2));
        Assertions.assertThat(targetNumArray.get(1)).isNotEqualTo(targetNumArray.get(2));

    }


}
