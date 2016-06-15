package map;

import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pavan.r on 15/06/16.
 */
public class StringToListOfString implements Function<String, List<String>> {
    @Override
    public List<String> call(String line) throws Exception {
        String[] parts = line.split(" ");
        return Arrays.asList(parts);
    }
}
