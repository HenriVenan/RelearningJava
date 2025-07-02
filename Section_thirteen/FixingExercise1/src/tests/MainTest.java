package tests;

import java.io.ByteArrayInputStream;

public class MainTest {
    public static void simulator(String... entradas) {
        String input = String.join("\n", entradas);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
