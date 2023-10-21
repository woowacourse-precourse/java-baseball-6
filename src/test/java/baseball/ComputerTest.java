package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    public void initTest() throws Exception {
        //given
        Computer computer = new Computer();

        for (int i = 0; i < 500; i++) {
            computer.init();
            List<Integer> answer = computer.getAnswer();

            Assertions.assertThat(answer.size())
                    .isEqualTo(3);

            Set<Integer> set = new HashSet<>();
            for (Integer n : answer) {
                set.add(n);
            }
            Assertions.assertThat(set.size())
                    .isEqualTo(3);
        }
    }

    @Test
    public void getResultTest1() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{1, 2, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{1, 2, 3});
        Result result = computer.getResult(input);

        //then
        isEqualsResult(result, 3, 0);
    }

    @Test
    public void getResultTest2() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{1, 2, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{2, 1, 3});
        Result result = computer.getResult(input);

        //then
        isEqualsResult(result, 1, 2);
    }

    @Test
    public void getResultTest3() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{1, 2, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{5, 4, 3});
        Result result = computer.getResult(input);

        //then
        isEqualsResult(result, 1, 0);
    }

    @Test
    public void getResultTest4() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{1, 2, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{5, 6, 7});
        Result result = computer.getResult(input);

        //then
        isEqualsResult(result, 0, 0);
    }

    //== 예시 테스트 ==//

    @Test
    public void getResultTest5() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{7, 1, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{1, 2, 3});
        Result result = computer.getResult(input);

        //then

        isEqualsResult(result, 1, 1);
    }

    @Test
    public void getResultTest6() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{7, 1, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{1, 4, 5});
        Result result = computer.getResult(input);

        //then

        isEqualsResult(result, 0, 1);
    }

    @Test
    public void getResultTest7() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{7, 1, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{6, 7, 1});
        Result result = computer.getResult(input);

        //then

        isEqualsResult(result, 0, 2);
    }

    @Test
    public void getResultTest8() throws Exception {
        //given
        Computer computer = new Computer();
        computer.setAnswer(new int[]{7, 1, 3});

        //when
        ArrayList<Integer> input = getUserInput(new int[]{2, 1, 6});
        Result result = computer.getResult(input);

        //then

        isEqualsResult(result, 1, 0);
    }

    private ArrayList<Integer> getUserInput(int[] input) {
        ArrayList<Integer> userInput = new ArrayList<>();
        for (int i : input) {
            userInput.add(i);
        }
        return userInput;
    }

    private ObjectAssert<Result> isEqualsResult(Result result, int strike, int ball) {
        return Assertions.assertThat(result)
                .isEqualTo(new Result(strike, ball));
    }
}