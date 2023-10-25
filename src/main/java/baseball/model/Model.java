package baseball.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record Model(
        Map<String, Object> model
) {

        public Model() {
                this(new HashMap<>());
        }

        public Object setAttribute(final String attribute, final Object value) {
                return model.put(attribute, value);
        }

        public Optional<Object> getAttribute(final String attribute) {
                return Optional.ofNullable(model.get(attribute));
        }
}
