package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserTest {

    private ByteArrayInputStream inputStream;
    private final String testInput = "225";
    @BeforeEach
    public void setUpInput() {
        // 유저가 입력할 값을 임의로 지정
        inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);
    }
    @Test
    void 자릿수가_3이아닌_숫자인_경우() throws IOException {
        // Arrange, Action
        User user = new User();
        String result = user.readLine();
        // Assert
        assertThat(result).isInstanceOf(String.class);
        if(result.length() != 3){
            assertThatThrownBy(() -> user.readLine())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}