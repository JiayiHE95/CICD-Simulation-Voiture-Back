package org.acme;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CompilateurTest {

  @Test
  void testCompileLineAvancer() throws IOException {
    StringWriter stringWriter = new StringWriter();
    BufferedWriter writer = new BufferedWriter(stringWriter);
    String instruction = Compilateur.compileLine("avancer 1", writer);
    assertEquals("case \"avancer\":\n" +
        "    position = position + 1;\n" +
        "    break;\n", instruction);
    writer.close();
  }

  @Test
  void testCompileLineReculer() throws IOException {
    StringWriter stringWriter = new StringWriter();
    BufferedWriter writer = new BufferedWriter(stringWriter);
    String instruction = Compilateur.compileLine("reculer 1", writer);
    assertEquals("case \"reculer\":\n" +
        "    position = position - 1;\n" +
        "    break;\n", instruction);
    writer.close();
  }

  @Test
  void testCompileLineDefault() throws IOException {
    StringWriter stringWriter = new StringWriter();
    BufferedWriter writer = new BufferedWriter(stringWriter);
    String instruction = Compilateur.compileLine("autre 1", writer);
    assertEquals("", instruction);
    writer.close();
  }

  @Test
  void testMain() {
    String[] args = {};
    Compilateur.main(args);
    assertTrue(new File("src/main/java/org/acme/Compile.java").exists());
  }

}
