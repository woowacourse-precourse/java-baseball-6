package repository;

import java.util.List;

public interface BaseRepository {

    List<Integer> getMyNumber(String myNumber);

    int[] confirmNumber(List<Integer> baseNumber, List<Integer> myNumber);

    void printMessage(int[] result);
}
