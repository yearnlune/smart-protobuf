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
}
