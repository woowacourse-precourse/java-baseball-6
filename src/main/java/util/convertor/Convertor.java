package util.convertor;

public interface Convertor<S, T> {

    T convert(S source);
}
