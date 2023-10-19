package baseball;

import java.util.List;

/** Represents a set of three numbers. */
public interface Numbers {
    public int firstNumber();
    public int secondNumber();
    public int thirdNumber();

    /**
     * Return all the numbers this object contains.
     * Any attempt to modify inner state of the list returned
     * doesn't affect the inner state of this object.
     * The returned list is a copy.
     * @return a list contains the 3 numbers this object contains.
     *         idx 0 stands for the first number, idx 1 stands for the
     *         second number, and so on.
     */
    public List<Integer> allNumbers();
}
