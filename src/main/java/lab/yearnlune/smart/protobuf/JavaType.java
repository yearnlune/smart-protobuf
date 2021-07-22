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

    INTEGER(Integer.class.getSimpleName(), 0),
    LONG(Long.class.getSimpleName(), 0L),
    DOUBLE(Double.class.getSimpleName(), Double.NaN),
    FLOAT(Float.class.getSimpleName(), Float.NaN),
    BOOLEAN(Boolean.class.getSimpleName(), false),
    BYTE_STRING(ByteString.class.getSimpleName(), ByteString.copyFromUtf8("")),
    BYTES(Byte[].class.getSimpleName(), new Byte[0]),
    STRING(String.class.getSimpleName(), "");

    private static final Map<String, JavaType> ENTRIES = Arrays.stream(JavaType.values())
        .collect(Collectors.toMap(JavaType::getName, v -> v));

    private String name;
    private Object defaultValue;

    private static JavaType forName(String value) {
        return ENTRIES.get(value);
    }

    private static <T> JavaType forValue(T value) {
        Class tClass = value.getClass();
        String simpleName = tClass.getSimpleName();
        return ENTRIES.get(simpleName);
    }
}
