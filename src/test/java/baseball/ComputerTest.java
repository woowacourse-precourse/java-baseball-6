package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer = new Computer();
    List<Integer> computerAnswer = computer.makeAnswer();

    @Test
    void computerAnswer의_자리수_테스트() {
        assertThat(computerAnswer.size()).isEqualTo(3);
    }

    @Test
    void computerAnswer의_중복숫자_없는지_테스트() {
        int cnt = 0;
        List<Integer> answerToArr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = computerAnswer.get(i);
            if(answerToArr.contains(num)) {
                cnt++;
            }
            answerToArr.add(num);
        }
        assertThat(cnt).isEqualTo(0);
    }

    @Test
    void computerAnswer의숫자가_1부터9사이에있는지_테스트() {
        boolean test = true;
        for (int i = 0; i < 3; i++) {
            int num = computerAnswer.get(i);
            if(!(num >= 1 && num <= 9)) {
                test = false;
                break;
            }
        }
        assertThat(test).isEqualTo(true);
    }
}