package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final Validator validator;
    List<Integer> baseball;

    public Baseball(Validator validator, List<Integer> baseball) {
        this.validator = new Validator();
        this.baseball = baseball;
    }


    public List<Integer> getUserNum() {
        List<Integer> userNumList = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String nums = Console.readLine();
        if (!validator.validateUserNum(nums)){
            throw new IllegalStateException("올바른 수를 입력하세요");
        }
        for (int i=0; i<3; i++) {
            userNumList.add(Integer.parseInt(nums.substring(i, i+1)));
        }
        return userNumList;

    }

}
