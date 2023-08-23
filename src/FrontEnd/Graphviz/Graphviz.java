/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd.Graphviz;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author ryoumen_kyoma
 */
public class Graphviz {
    

  public static void generateGraphic(String dotCode, String outputFileName) throws IOException {
    File dotFile = new File("temp.dot");
    PrintWriter writer = new PrintWriter(dotFile);
    try {
      writer.println(dotCode);
      writer.close();
    } catch (Throwable throwable) {
      try {
        writer.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
    String[] cmd = { "dot", "-Tpng", "-o" + outputFileName, "temp.dot" };
    ProcessBuilder processBuilder = new ProcessBuilder(cmd);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    try {
      process.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    dotFile.delete();
  }
}

