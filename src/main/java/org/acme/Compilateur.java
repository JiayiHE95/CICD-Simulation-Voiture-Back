package org.acme;

import java.nio.file.Paths;
import java.io.*;

public class Compilateur {
  public static void main(String... args) {
    String absolutePath = Paths.get(".").toAbsolutePath().normalize().toString();
    absolutePath += "\\src\\main\\java\\org\\acme\\";

    String inputFileName = "compile.jiayi";
    String outputFileName = "Compile.java";
    String inputFilePath = absolutePath + inputFileName;
    String outputFilePath = absolutePath + outputFileName;
    String beginning = "package org.acme;\n" +
        "public class Compile {\n" +
        "    int position = 0;\n" +
        "    public void move(String direction) {\n" +
        "        switch (direction) {\n";
    String ending = "        default:\n" +
        "            System.out.println(\"Mauvaise direction\");\n" +
        "            break;\n" +
        "       }\n" +
        "    }\n" +
        "}\n";

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

      writer.write(beginning);
      reader.lines().forEach(line -> {
        try {
          compileLine(line, writer);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      writer.write(ending);

    } catch (IOException e) {
      System.err.println("Erreur lors de la compilation : " + e.getMessage());
    }
  }

  public static String compileLine(String line, BufferedWriter writer) throws IOException {
    String[] words = line.split(" ");
    String key = words[0];
    String instruction = "";
    switch (key) {
      case "avancer":
        instruction = "        case \"avancer\":\n" +
            "            position = position + 1;\n" +
            "            break;\n";
        break;
      case "reculer":
        instruction = "        case \"reculer\":\n" +
            "            position = position - 1;\n" +
            "            break;\n";
        break;
      default:
        break;
    }
    writer.write(instruction);
    return instruction;
  }
}
