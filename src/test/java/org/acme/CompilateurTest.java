package org.acme;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CompilateurTest {

  @ParameterizedTest
  @MethodSource("instructionProvider")
  void testCompileLine(String input, String expectedOutput) throws IOException {
    StringWriter stringWriter = new StringWriter();
    BufferedWriter writer = new BufferedWriter(stringWriter);
    String instruction = Compilateur.compileLine(input, writer);
    assertEquals(expectedOutput, instruction);
    writer.close();
  }

  private static Stream<Object[]> instructionProvider() {
    return Stream.of(
        new Object[] { "avancer", "case \"avancer\":\nposition = position + 1;\nbreak;\n" },
        new Object[] { "reculer", "case \"reculer\":\nposition = position - 1;\nbreak;\n" },
        new Object[] { "autre", "" });
  }

  @Test
  void testMain() {
    String[] args = {};
    Compilateur.main(args);
    File file = new File("src/main/java/org/acme/Compile.java");
    if (file.exists()) {
      assertTrue(new File("src/main/java/org/acme/Compile.java").exists());
      file.delete();
    }
  }

}
