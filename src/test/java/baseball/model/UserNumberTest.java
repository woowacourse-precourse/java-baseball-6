package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberTest {

    @DisplayName("사용자 수 정상적인 값 입력되면 성공")
    @Test
    void inputNormalUserNumber(){
        String inputNumber = "123";
        UserNumber userNumber = new UserNumber(inputNumber);
        assertThat(userNumber.getNumber()).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("사용자 수가 비어있다면 에러 발생")
    @Test
    void inputEmptyUserNumber(){
        String inputNumber = "";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("사용자 수가 여러개의 공백으로 입력된다면 에러 발생")
    @Test
    void inputBlankUserNumber(){
        String inputNumber = "   ";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("사용자 수가 숫자값이 아니라면 에러 발생")
    @Test
    void inputNotDigitString(){
        String inputNumber = "great";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("사용자 수가 숫자와 문자가 섞인 값이 입력된다면 에러 발생")
    @Test
    void inputMixedCharacterAndDigitString(){
        String inputNumber = "great1234";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("사용자 수의 길이가 3보다 큰 값이 입력되면 에러 발생")
    @Test
    void inputOverThreeDigit(){
        String inputNumber = "1234";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 숫자를 입력해주세요");
    }

    @DisplayName("사용자 수의 길이가 3보다 작은 값이 입력되면 에러 발생")
    @Test
    void inputUnderThreeDigit(){
        String inputNumber = "12";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 숫자를 입력해주세요");
    }

    @DisplayName("사용자 수가 범위를 넘어가면 에러 발생")
    @Test
    void inputOutOfRange(){
        String inputNumber = "120";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각자리의 숫자가 1부터 9사이의 숫자로 이루어져야 합니다");
    }

    @DisplayName("사용자 수에 중복된 값 존재하면 에러 발생")
    @Test
    void inputDuplicateNumber(){
        String inputNumber = "122";
        assertThatThrownBy(() -> new UserNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 존재하지 않아야 합니다");
    }

    @DisplayName("String 타입을 List<Integer> 타입으로 교체")
    @Test
    void convertStringToIntegerList() throws NoSuchMethodException{
        String stringValue = "123";
        List<Integer> expectedNumbers = List.of(1, 2, 3);
        UserNumber userNumber = new UserNumber(stringValue);
        Method method = userNumber.getClass().getDeclaredMethod("StringToList", String.class);
        method.setAccessible(true);

        try{
            List<Integer> resultList = (List<Integer>) method.invoke(userNumber, stringValue);
            assertThat(expectedNumbers).isEqualTo(resultList);

        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}