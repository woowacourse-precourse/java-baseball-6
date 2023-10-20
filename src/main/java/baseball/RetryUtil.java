package baseball;

import java.util.function.Function;
import java.util.function.Supplier;

public class RetryUtil {

    public static <T, R> R read(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return read(function, input);
        }
    }
    public static <T> T read(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return read(supplier);
        }
    }
}
