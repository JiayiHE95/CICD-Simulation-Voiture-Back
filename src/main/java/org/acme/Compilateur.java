package org.acme;

import java.nio.file.Paths;

import java.io.*;

import java.util.logging.*;

public class Compilateur {

  public static void main(String... args) {

    Logger logger = Logger.getLogger(Compilateur.class.getName());

    String absolutePath = Paths.get(".").toAbsolutePath().normalize().toString();
    absolutePath += "\\src\\main\\java\\org\\acme\\";

    String inputFileName = "compile.jiayi";
    String outputFileName = "Compile.java";
    String inputFilePath = absolutePath + inputFileName;
    String outputFilePath = absolutePath + outputFileName;
    String beginning = """
            package org.acme;

            public class Compile {
                int position = 0;

                public void move(String direction) {
                    switch (direction) {
        """;

    String ending = """
            default:
                System.out.println("Mauvaise direction");
                break;
          }
        }
        }
        """;

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

      writer.write(beginning);
      reader.lines().forEach(line -> {
        try {
          compileLine(line, writer);
        } catch (IOException e) {
          logger.info("Erreur lors de la compilation : " + e.getMessage());
        }
      });
      writer.write(ending);

    } catch (IOException e) {
      logger.info("Erreur lors de la compilation : " + e.getMessage());
    }
  }

  public static String compileLine(String line, BufferedWriter writer) throws IOException {
    String[] words = line.split(" ");
    String key = words[0];
    String instruction = "";
    switch (key) {
      case "avancer":
        instruction = """
            case \"avancer\":
                position = position + 1;
                break;\n""";
        break;
      case "reculer":
        instruction = """
            case \"reculer\":
                position = position - 1;
                break;\n""";
        break;
      default:
        break;
    }
    writer.write(instruction);
    return instruction;
  }
}
