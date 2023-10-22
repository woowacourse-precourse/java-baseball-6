package baseball;

import baseball.computer.ComputerNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ComputerNumberGeneratorTest {

    @Test
    void generateNumbers() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> generatedNumbers = computerNumberGenerator.generateNumbers();

        // check list size
        Assertions.assertEquals(3, generatedNumbers.size());

        // check distinct numbers
        Set<Integer> distinctNumbers = new HashSet<>(generatedNumbers);
        Assertions.assertEquals(3, distinctNumbers.size());

        System.out.println(generatedNumbers);
    }
    @Test
    void generateNumbers2() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> generatedNumbers = computerNumberGenerator.generateNumbers();

        // check list size
        Assertions.assertEquals(3, generatedNumbers.size());

        // check distinct numbers
        Set<Integer> distinctNumbers = new HashSet<>(generatedNumbers);
        Assertions.assertEquals(3, distinctNumbers.size());

        System.out.println(generatedNumbers);
    }
}