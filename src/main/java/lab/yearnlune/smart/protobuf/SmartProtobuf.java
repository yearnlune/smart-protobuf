package lab.yearnlune.smart.protobuf;

import java.util.function.Consumer;

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
}
