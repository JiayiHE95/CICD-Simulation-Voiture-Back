package org.acme;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CompilateurTest {

 @Test
 public void testCompileLineAvancer() throws IOException {
  StringWriter stringWriter = new StringWriter();
  BufferedWriter writer = new BufferedWriter(stringWriter);
  String instruction = Compilateur.compileLine("avancer 1", writer);
  assertEquals("        case \"avancer\":\n" +
    "            position = position + 1;\n" +
    "            break;\n", instruction);
  writer.close();
 }

 @Test
 public void testCompileLineReculer() throws IOException {
  StringWriter stringWriter = new StringWriter();
  BufferedWriter writer = new BufferedWriter(stringWriter);
  String instruction = Compilateur.compileLine("reculer 1", writer);
  assertEquals("        case \"reculer\":\n" +
    "            position = position - 1;\n" +
    "            break;\n", instruction);
  writer.close();
 }

 @Test
 public void testCompileLineDefault() throws IOException {
  StringWriter stringWriter = new StringWriter();
  BufferedWriter writer = new BufferedWriter(stringWriter);
  String instruction = Compilateur.compileLine("autre 1", writer);
  assertEquals("", instruction);
  writer.close();
 }

}
