import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.example.ProcessingArray.processingArray;

public class TestClass {
    @Test
    public void processingArrayTest() {
        String[] input = {"qwe","wqe","qwee","a","a", "aa"};
        String expected = "a = 3, 4 qwe = 0, 1";
        String actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{"a", "aa"};
        expected = "";
        actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{" ", "  ", " ", "  "};
        expected = "  = 0, 2    = 1, 3";
        actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{"", "", ""};
        expected = "";
        actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{"qwe", "QWE", "qWe"};
        expected = "";
        actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{" b ", "  b", "b  "};
        expected = " b  = 0, 1, 2";
        actual = processingArray(input);
        assertEquals(expected, actual);

        input = new String[]{"qwe"};
        expected = "";
        actual = processingArray(input);
        assertEquals(expected, actual);
    }

}
