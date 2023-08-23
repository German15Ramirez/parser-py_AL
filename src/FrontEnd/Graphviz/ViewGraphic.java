/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd.Graphviz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author ryoumen_kyoma
 */
public class ViewGraphic {
    private JPanel jPanel1;
  
  private JLabel labelGrafico;
  
  private JScrollPane scrollPane;
  
  public ViewGraphic() {
//    setTitle("Grrafico");
    initComponents();
    this.labelGrafico.setText("");
  }
  private void initComponents() {
    this.scrollPane = new JScrollPane();
    this.jPanel1 = new JPanel();
    this.labelGrafico = new JLabel();
//    setDefaultCloseOperation(2);
    this.scrollPane.setHorizontalScrollBarPolicy(32);
    this.jPanel1.setLayout(new BorderLayout());
    this.labelGrafico.setBackground(new Color(153, 153, 153));
    this.labelGrafico.setText("jLabel1");
    this.jPanel1.add(this.labelGrafico, "First");
    this.scrollPane.setViewportView(this.jPanel1);
//    getContentPane().add(this.scrollPane, "Center");
//    pack();
  }
  public void obtenerLexema(String lexema) {
    StringBuilder dotCode = new StringBuilder("digraph G {\n");
    dotCode.append("rankdir=LR;\n");
    dotCode.append("node [shape=oval];\n");
    for (int i = 0; i < lexema.length(); i++) {
      char character = lexema.charAt(i);
      String label = escapeDotLabel(character);
      dotCode.append(i).append(" [label=\"").append(label).append("\"];\n");
      if (i == lexema.length() - 1)
        dotCode.append(i).append(" [peripheries=2];\n"); 
      if (i > 0)
        dotCode.append(i - 1).append(" -> ").append(i).append(";\n"); 
    } 
    dotCode.append("}");
    try {
      File dotFile = File.createTempFile("graph", ".dot");
      dotFile.deleteOnExit();
      File imageFile = new File(dotFile.getAbsolutePath() + ".png");
      Utils.writeStringToFile(dotCode.toString(), dotFile.getAbsolutePath());
      ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "dot", "-Tpng", dotFile.getAbsolutePath(), "-o", imageFile.getAbsolutePath() });
      Process process = processBuilder.start();
      int exitCode = process.waitFor();
      if (exitCode == 0) {
        this.labelGrafico.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
//        setSize(this.labelGrafico.getWidth(), this.labelGrafico.getHeight());
//        pack();
      } else {
        System.err.println("Error al generar el gr");
      } 
    } catch (IOException|InterruptedException ex) {
      ex.printStackTrace();
    } 
  }
  
  private String escapeDotLabel(char character) {
    if (character == '"' || character == '\'')
      return "\\" + character; 
    return String.valueOf(character);
  }
  
  private static class Utils {
    public static void writeStringToFile(String content, String filePath) throws IOException {
      FileWriter writer = new FileWriter(filePath);
      try {
        writer.write(content);
        writer.close();
      } catch (Throwable throwable) {
        try {
          writer.close();
        } catch (Throwable throwable1) {
          throwable.addSuppressed(throwable1);
        } 
        throw throwable;
      } 
    }
  }
}



