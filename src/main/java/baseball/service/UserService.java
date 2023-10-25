package baseball.service;

import baseball.domain.Numbers;
import baseball.domain.User;
import baseball.dto.request.UserNumberRequest;

public class UserService {
    public User createUserNumber(final UserNumberRequest userNumberRequest) {
        return new User(createNumber(userNumberRequest));
    }

    private Numbers createNumber(final UserNumberRequest userNumberRequest) {
        return new Numbers(userNumberRequest.getNumberList());
    }
}
