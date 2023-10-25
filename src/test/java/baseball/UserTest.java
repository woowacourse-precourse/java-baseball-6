package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.List;



class UserTest {
    public User user = new User();

    private List<Integer> userInput(String input){
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        List<Integer> nums = user.inputNumbers();
        return nums;
    }
    @Test
    public void correctInputNumbersTest(){

        List<Integer> nums = userInput("124");

        Assertions.assertThat(nums).containsExactly(1,2,4);
    }
    @Test
    public void longerInputNumbersTest(){
        Assertions.assertThatThrownBy(()->{userInput("1248");}).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("잘못된 입력입니다");
    }
    @Test
    public void duplicatedInputNumbersTest(){
        Assertions.assertThatThrownBy(()->{userInput("122");}).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("잘못된 입력입니다");
    }

    @Test
    public void characterInputNumbersTest(){
        Assertions.assertThatThrownBy(()->{userInput("1s2");}).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("잘못된 입력입니다");
    }

}