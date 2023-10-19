package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
    private Person person;

    @BeforeEach
    void setup() {
        person = new Person();
    }

    @Test
    void insert() {
        String input = "123";

        person.insert(input);

        assertEquals(person.getInputList().get(0), 1);
    }
}
