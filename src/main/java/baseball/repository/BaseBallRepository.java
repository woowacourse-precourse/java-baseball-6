package baseball.repository;

import baseball.domain.BaseBall;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class BaseBallRepository {

    private final AtomicLong atomicGeneratedId = new AtomicLong(0);
    private final List<BaseBall> data = new ArrayList<>();


    public BaseBall save(BaseBall baseBall, List<Integer> inputNumbers) {
        if (baseBall.getId() == null || baseBall.getId() == 0L) {
            baseBall.setId(atomicGeneratedId.incrementAndGet());
            baseBall.setInputBallNumber(inputNumbers);
            data.add(baseBall);
            return baseBall;
        }
        data.removeIf(element -> Objects.equals(element.getId(), baseBall.getId()));
        data.add(baseBall);
        return baseBall;
    }

    public BaseBall findById(Long id) {
        return data.stream()
                .filter(element -> Objects.equals(element.getId(), id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));

    }
}
