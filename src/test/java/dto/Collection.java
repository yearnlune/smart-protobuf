package dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {

    private List<Double> doubleValues;
    private List<Float> floatValues;
    private List<Integer> int32Values;
    private List<Long> int64Values;
    private List<Integer> uint32Values;
    private List<Long> uint64Values;
    private List<Integer> sint32Values;
    private List<Long> sint64Values;
    private List<Integer> fixed32Values;
    private List<Long> fixed64Values;
    private List<Integer> sfixed32Values;
    private List<Long> sfixed64Values;
    private List<Boolean> boolValues;
    private List<String> stringValues;
    private List<byte[]> bytesValues;
}
