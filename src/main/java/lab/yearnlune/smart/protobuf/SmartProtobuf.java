package lab.yearnlune.smart.protobuf;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

public class SmartProtobuf {

    /**
     * Set proto field using proto builder
     *
     * ex) setProtoField(scalarBuilder::setDoubleValue, 0.12);
     *
     * @param setter ProtoBuf Builder Setter
     * @param value value
     */
    public static <T> void setProtoField(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }

    /**
     * get safety(Not null) value
     *
     * @param value value
     * @param type value type
     * @return value, default value if the value is null
     */
    public static <T> T getValueSafely(T value, JavaType type) {
        T safeValue = (T)type.getDefaultValue();
        if (value != null) {
            safeValue = value;
        }
        return safeValue;
    }

    /**
     * get safety(Not null) value
     *
     * @param values collection value
     * @param <T> value type
     * @return value, empty list if the value is null
     */
    public static <T> List<T> getValueSafely(List<T> values) {
        List<T> safeValues = Collections.emptyList();
        if (values != null && !values.isEmpty()) {
            safeValues = values;
        }

        return safeValues;
    }

    public static <P extends GeneratedMessageV3.Builder, T> void setProto(P protoBuilder, T object) {
        Descriptors.Descriptor descriptor = protoBuilder.getDescriptorForType();

        List<Descriptors.FieldDescriptor> protoFields = descriptor.getFields();

        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, Object> map = Stream.of(fields)
            .collect(Collectors.toMap(Field::getName, v -> {
                try {
                    v.setAccessible(true);
                    return v.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }));

        for (Descriptors.FieldDescriptor protoField : protoFields) {
            Object value = map.get(protoField.getName());
            if (value != null) {
                protoBuilder.setField(protoField, value);
            }
        }
    }
}
