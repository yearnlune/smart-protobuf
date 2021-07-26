package lab.yearnlune.smart.protobuf;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.protobuf.ByteString;

public class SmartProtobufTest {

    @Test
    public void setProtoField_scalarField_shouldBeSet() {
        /* GIVEN */
        double doubleValue = 0.12d;
        float floatValue = 0.12f;
        int int32Value = 32;
        long int64Value = 64L;
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
    public void setProtoField_nullScalarField_shouldBeSetDefaultValue() {
        /* GIVEN */
        Double doubleValue = null;
        Float floatValue = null;
        Integer int32Value = null;
        Long int64Value = null;
        Boolean boolValue = null;
        String stringValue = null;
        ByteString bytesValue = null;

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
        assertThat(scalar.getBytesValue(), is(JavaType.BYTES.getDefaultValue()));
    }

    @Test
    public void setProtoField_collectionField_shouldBeSet() {
        /* GIVEN */
        List<Double> doubleValues = Arrays.asList(0.1d, 0.2d, 0.3d);
        List<Float> floatValues = Arrays.asList(0.1f, 0.2f, 0.3f);
        List<Integer> int32Values = Arrays.asList(1, 2, 3);
        List<Long> int64Values = Arrays.asList(1L, 2L, 3L);
        List<Boolean> boolValues = Arrays.asList(true, false, true);
        List<String> stringValues = Arrays.asList("One", "Two", "Three");
        List<ByteString> bytesValues = Arrays.asList(ByteString.copyFromUtf8(stringValues.get(0)),
            ByteString.copyFromUtf8(stringValues.get(1)), ByteString.copyFromUtf8(stringValues.get(2)));

        ExampleProto.Collection.Builder collectionBuilder = ExampleProto.Collection.newBuilder();

        /* WHEN */
        SmartProtobuf.setProtoField(collectionBuilder::addAllDoubleValues, doubleValues);
        SmartProtobuf.setProtoField(collectionBuilder::addAllFloatValues, floatValues);
        SmartProtobuf.setProtoField(collectionBuilder::addAllInt32Values, int32Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllInt64Values, int64Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllUint32Values, int32Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllUint64Values, int64Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllSint32Values, int32Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllSint64Values, int64Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllFixed32Values, int32Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllFixed64Values, int64Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllSfixed32Values, int32Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllSfixed64Values, int64Values);
        SmartProtobuf.setProtoField(collectionBuilder::addAllBoolValues, boolValues);
        SmartProtobuf.setProtoField(collectionBuilder::addAllStringValues, stringValues);
        SmartProtobuf.setProtoField(collectionBuilder::addAllBytesValues, bytesValues);

        ExampleProto.Collection collection = collectionBuilder.build();

        /* THEN */
        assertThat(collection.getDoubleValuesList(), is(doubleValues));
        assertThat(collection.getFloatValuesList(), is(floatValues));
        assertThat(collection.getInt32ValuesList(), is(int32Values));
        assertThat(collection.getInt64ValuesList(), is(int64Values));
        assertThat(collection.getUint32ValuesList(), is(int32Values));
        assertThat(collection.getUint64ValuesList(), is(int64Values));
        assertThat(collection.getSint32ValuesList(), is(int32Values));
        assertThat(collection.getSint64ValuesList(), is(int64Values));
        assertThat(collection.getFixed32ValuesList(), is(int32Values));
        assertThat(collection.getFixed64ValuesList(), is(int64Values));
        assertThat(collection.getSfixed32ValuesList(), is(int32Values));
        assertThat(collection.getSfixed64ValuesList(), is(int64Values));
        assertThat(collection.getBoolValuesList(), is(boolValues));
        assertThat(collection.getStringValuesList(), is(stringValues));
        assertThat(collection.getBytesValuesList(), is(bytesValues));
    }

    @Test
    public void getValueSafely_scalarNullValue_shouldBeSetDefaultValue() {
        /* GIVEN */
        Double doubleValue = null;
        Float floatValue = null;
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
            .setBytesValue(SmartProtobuf.getValueSafely(byteStringValue, JavaType.BYTES))
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
        assertThat(scalar.getBytesValue(), is(JavaType.BYTES.getDefaultValue()));
    }
}
