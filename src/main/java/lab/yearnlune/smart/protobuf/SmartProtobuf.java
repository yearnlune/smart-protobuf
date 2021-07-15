package lab.yearnlune.smart.protobuf;

import java.util.function.Consumer;

public class SmartProtobuf {

    public static <T> void setProtoField(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}
