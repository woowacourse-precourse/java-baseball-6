package baseball;

import baseball.player.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    @DisplayName("유효한 입력값을 잘 저장하는지 테스트")
    public void testInsertNumberAndValidate_ValidInput() {
        String input = "123";
        person.insertNumberAndValidate(input);

        Assertions.assertEquals(1, person.getNumberAt(0));
        Assertions.assertEquals(2, person.getNumberAt(1));
        Assertions.assertEquals(3, person.getNumberAt(2));
    }

    @Test
    @DisplayName("유효하지 않은 입력값에 대한 예외 처리 테스트")
    public void testInsertNumberAndValidate_InvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> person.insertNumberAndValidate("12a"));
    }

    @Test
    @DisplayName("clean 메서드가 리스트를 잘 초기화하는지 테스트")
    public void testClean() {
        person.insertNumberAndValidate("123");
        person.cleanList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> person.getNumberAt(0));
    }

    @Test
    @DisplayName("유효하지 않은 인덱스에 접근할 때 예외 처리 테스트")
    public void testGetNumberAt_InvalidIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> person.getNumberAt(-1));
    }
}
