package baseball.dto;

import java.util.List;

public record UserRequest(String cmd, List<String> args) {
}
