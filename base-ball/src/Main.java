import java.util.Arrays;
import java.util.List;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30);

        // `StringBuilder` 클래스를 사용하여 List의 값을 연결합니다.
        StringBuilder numbersStr = new StringBuilder();
        for (Integer number : numbers) {
            numbersStr.append(number).append(", ");
        }
        numbersStr.delete(numbersStr.length() - 2, numbersStr.length());

        // List의 값을 출력합니다.
        System.out.println(numbersStr);
        }
    }
}