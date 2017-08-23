package pl.net.kopczynski;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void should_return_empty_list() throws IOException {
        // given
        DocumentContext documentContext = JsonPath.parse(new File(getClass().getClassLoader().getResource("test.json").getFile()));

        // when
        List<String> value = documentContext.read("$.wrapper.data_missing[?(@.id=='2')]");

        // then
        assertThat(value).isEmpty();
    }
}
