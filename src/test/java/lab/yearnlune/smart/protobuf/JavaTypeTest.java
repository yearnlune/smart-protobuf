package lab.yearnlune.smart.protobuf;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class JavaTypeTest {

    @Test
    public void forName_existedValue_shouldBeReturnedJavaType() {
        JavaType javaType = JavaType.forName("byteString");

        assertThat(javaType, is(JavaType.BYTES));
    }

    @Test
    public void forName_notExistedValue_shouldBeReturnedNullValue() {
        JavaType javaType = JavaType.forName("empty");

        assertThat(javaType, nullValue());
    }

    @Test
    public void forValue_existedValue_shouldBeReturnedJavaType() {
        JavaType javaType = JavaType.forValue("ABC");

        assertThat(javaType, is(JavaType.STRING));
    }

    @Test
    public void forValue_nullValue_shouldBeReturnedNullValue() {
        JavaType javaType = JavaType.forValue(null);

        assertThat(javaType, nullValue());
    }
}
