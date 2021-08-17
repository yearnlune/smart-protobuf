package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scalar {

    private double doubleValue;
    private float floatValue;
    private int int32Value;
    private long int64Value;
    private int uint32Value;
    private long uint64Value;
    private int sint32Value;
    private long sint64Value;
    private int fixed32Value;
    private long fixed64Value;
    private int sfixed32Value;
    private long sfixed64Value;
    private boolean boolValue;
    private String stringValue;
    private byte[] bytesValue;
}
