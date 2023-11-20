package baseball.domain;

import baseball.Error.ErrorMessage;
import baseball.domain.UserNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserNumberTest {
    @Test
    @DisplayName("모든 기준을 만족시킬때")
    void meetAllCriteria(){
        UserNumber result = new UserNumber("146");
        assertThat(List.of(1,4,6)).isEqualTo(result.getNumbers());
    }

    @Test
    @DisplayName("공백이 있을 때 제거하는지 확인")
    void deleteBlank(){
        UserNumber result = new UserNumber("14  6 ");
        assertThat(List.of(1,4,6)).isEqualTo(result.getNumbers());
    }
    @Test
    @DisplayName("입력 숫자가 3개보다 많으면 예외메세지를 띄운다.")
    void createUserNumbersByOverSize(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new UserNumber("1462"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NUMBERS_OVERSIZE.getMessage());
    }

    @Test
    @DisplayName("입력 숫자가 3개보다 작으면 예외메세지를 띄운다.")
    void createUserNumbersByUnderSize(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new UserNumber("14"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NUMBERS_UNDERSIZE.getMessage());
    }

    @Test
    @DisplayName("0을 포함하고 있으면 예외메세지를 띄운다.")
    void includeInvalidNumber(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new UserNumber("140"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INCLUDE_INVALID_NUMBER.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 있다면 예외메세지를 띄운다.")
    void IncludeDuplicateNumber(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new UserNumber("144"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INCLUDE_DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("숫자 이외의 것이 입력되면 예외메세지를 띄운다.")
    void IncludeNotNumber(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new UserNumber("1 가4"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INCLUDE_NOT_NUMBER.getMessage());
    }
}
