package lab.yearnlune.smart.protobuf;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.google.protobuf.ByteString;

public class SmartProtobufTest {

    @Test
    public void setProtoField_scalarField_shouldBeSet() {
        /* GIVEN */
        double doubleValue = 0.12;
        float  floatValue = 0.12f;
        int int32Value = 32;
        long int64Value = 64;
        boolean boolValue = true;
        String stringValue = "string";
        byte[] bytes = stringValue.getBytes(StandardCharsets.UTF_8);
        ByteString bytesValue = ByteString.copyFrom(bytes);

        ExampleProto.Scalar.Builder scalarBuilder = ExampleProto.Scalar.newBuilder();

        /* WHEN */
        SmartProtobuf.setProtoField(scalarBuilder::setDoubleValue, doubleValue);
        SmartProtobuf.setProtoField(scalarBuilder::setFloatValue, floatValue);
        SmartProtobuf.setProtoField(scalarBuilder::setInt32Value, int32Value);
        SmartProtobuf.setProtoField(scalarBuilder::setInt64Value, int64Value);
        SmartProtobuf.setProtoField(scalarBuilder::setUint32Value, int32Value);
        SmartProtobuf.setProtoField(scalarBuilder::setUint64Value, int64Value);
        SmartProtobuf.setProtoField(scalarBuilder::setSint32Value, int32Value);
        SmartProtobuf.setProtoField(scalarBuilder::setSint64Value, int64Value);
        SmartProtobuf.setProtoField(scalarBuilder::setFixed32Value, int32Value);
        SmartProtobuf.setProtoField(scalarBuilder::setFixed64Value, int64Value);
        SmartProtobuf.setProtoField(scalarBuilder::setSfixed32Value, int32Value);
        SmartProtobuf.setProtoField(scalarBuilder::setSfixed64Value, int64Value);
        SmartProtobuf.setProtoField(scalarBuilder::setBoolValue, boolValue);
        SmartProtobuf.setProtoField(scalarBuilder::setStringValue, stringValue);
        SmartProtobuf.setProtoField(scalarBuilder::setBytesValue, bytesValue);

        ExampleProto.Scalar scalar = scalarBuilder.build();

        /* THEN */
        assertThat(scalar.getDoubleValue(), is(doubleValue));
        assertThat(scalar.getFloatValue(), is(floatValue));
        assertThat(scalar.getInt32Value(), is(int32Value));
        assertThat(scalar.getInt64Value(), is(int64Value));
        assertThat(scalar.getUint32Value(), is(int32Value));
        assertThat(scalar.getUint64Value(), is(int64Value));
        assertThat(scalar.getSint32Value(), is(int32Value));
        assertThat(scalar.getSint64Value(), is(int64Value));
        assertThat(scalar.getFixed32Value(), is(int32Value));
        assertThat(scalar.getFixed64Value(), is(int64Value));
        assertThat(scalar.getSfixed32Value(), is(int32Value));
        assertThat(scalar.getSfixed64Value(), is(int64Value));
        assertThat(scalar.getBoolValue(), is(boolValue));
        assertThat(scalar.getStringValue(), is(stringValue));
        assertThat(scalar.getBytesValue(), is(bytesValue));
    }

    @Test
    public void getValueSafely_scalarNullValue_shouldBeSetDefaultValue() {
        /* GIVEN */
        Double doubleValue = null;
        Float  floatValue = null;
        Integer int32Value = null;
        Long int64Value = null;
        Boolean boolValue = null;
        String stringValue = null;
        ByteString byteStringValue = null;

        /* WHEN */
        ExampleProto.Scalar scalar = ExampleProto.Scalar.newBuilder()
            .setDoubleValue(SmartProtobuf.getValueSafely(doubleValue, JavaType.DOUBLE))
            .setFloatValue(SmartProtobuf.getValueSafely(floatValue, JavaType.FLOAT))
            .setInt32Value(SmartProtobuf.getValueSafely(int32Value, JavaType.INTEGER))
            .setInt64Value(SmartProtobuf.getValueSafely(int64Value, JavaType.LONG))
            .setUint32Value(SmartProtobuf.getValueSafely(int32Value, JavaType.INTEGER))
            .setUint64Value(SmartProtobuf.getValueSafely(int64Value, JavaType.LONG))
            .setSint32Value(SmartProtobuf.getValueSafely(int32Value, JavaType.INTEGER))
            .setSint64Value(SmartProtobuf.getValueSafely(int64Value, JavaType.LONG))
            .setFixed32Value(SmartProtobuf.getValueSafely(int32Value, JavaType.INTEGER))
            .setFixed64Value(SmartProtobuf.getValueSafely(int64Value, JavaType.LONG))
            .setSfixed32Value(SmartProtobuf.getValueSafely(int32Value, JavaType.INTEGER))
            .setSfixed64Value(SmartProtobuf.getValueSafely(int64Value, JavaType.LONG))
            .setBoolValue(SmartProtobuf.getValueSafely(boolValue, JavaType.BOOLEAN))
            .setStringValue(SmartProtobuf.getValueSafely(stringValue, JavaType.STRING))
            .setBytesValue(SmartProtobuf.getValueSafely(byteStringValue, JavaType.BYTE_STRING))
            .build();

        /* THEN */
        assertThat(scalar.getDoubleValue(), is(JavaType.DOUBLE.getDefaultValue()));
        assertThat(scalar.getFloatValue(), is(JavaType.FLOAT.getDefaultValue()));
        assertThat(scalar.getInt32Value(), is(JavaType.INTEGER.getDefaultValue()));
        assertThat(scalar.getInt64Value(), is(JavaType.LONG.getDefaultValue()));
        assertThat(scalar.getUint32Value(), is(JavaType.INTEGER.getDefaultValue()));
        assertThat(scalar.getUint64Value(), is(JavaType.LONG.getDefaultValue()));
        assertThat(scalar.getSint32Value(), is(JavaType.INTEGER.getDefaultValue()));
        assertThat(scalar.getSint64Value(), is(JavaType.LONG.getDefaultValue()));
        assertThat(scalar.getFixed32Value(), is(JavaType.INTEGER.getDefaultValue()));
        assertThat(scalar.getFixed64Value(), is(JavaType.LONG.getDefaultValue()));
        assertThat(scalar.getSfixed32Value(), is(JavaType.INTEGER.getDefaultValue()));
        assertThat(scalar.getSfixed64Value(), is(JavaType.LONG.getDefaultValue()));
        assertThat(scalar.getBoolValue(), is(JavaType.BOOLEAN.getDefaultValue()));
        assertThat(scalar.getStringValue(), is(JavaType.STRING.getDefaultValue()));
        assertThat(scalar.getBytesValue(), is(JavaType.BYTE_STRING.getDefaultValue()));
    }
}
