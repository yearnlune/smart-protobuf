package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WrapperScalar {

    private Double doubleValue;
    private Float floatValue;
    private Integer int32Value;
    private Long int64Value;
    private Integer uint32Value;
    private Long uint64Value;
    private Integer sint32Value;
    private Long sint64Value;
    private Integer fixed32Value;
    private Long fixed64Value;
    private Integer sfixed32Value;
    private Long sfixed64Value;
    private Boolean boolValue;
    private String stringValue;
    private byte[] bytesValue;
}
