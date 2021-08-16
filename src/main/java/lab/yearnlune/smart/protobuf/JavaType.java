package lab.yearnlune.smart.protobuf;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.protobuf.ByteString;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JavaType {

    INTEGER(Integer.class.getSimpleName().toLowerCase(), 0),
    LONG(Long.class.getSimpleName().toLowerCase(), 0L),
    DOUBLE(Double.class.getSimpleName().toLowerCase(), 0.0d),
    FLOAT(Float.class.getSimpleName().toLowerCase(), 0.0f),
    BOOLEAN(Boolean.class.getSimpleName().toLowerCase(), false),
    BYTES(ByteString.class.getSimpleName().toLowerCase(), ByteString.copyFromUtf8("")),
    STRING(String.class.getSimpleName().toLowerCase(), "");

    private static final Map<String, JavaType> ENTRIES = Arrays.stream(JavaType.values())
        .collect(Collectors.toMap(JavaType::getName, v -> v));

    private String name;
    private Object defaultValue;

    public static JavaType forName(String value) {
        return ENTRIES.get(value.toLowerCase());
    }

    public static <T> JavaType forValue(T value) {
        if (value == null) {
            return null;
        }

        Class<?> tClass = value.getClass();
        String simpleName = tClass.getSimpleName().toLowerCase();
        return ENTRIES.get(simpleName);
    }
}
