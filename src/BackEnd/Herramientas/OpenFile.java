/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ryoumen_kyoma
 */
public class OpenFile {
 public static void openFileAndSetText(JTextPane jTextPane) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Python (.py)", "py");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            String fileContent = loadTxtFile(selectedFile);
            jTextPane.setText(fileContent);
        } catch (IOException e) {
            handleFileLoadError(e);
        }
    }
}

   public static String loadTxtFile(File file) throws IOException {
    try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        return content.toString();
    }
}


   private static void handleFileLoadError(Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
}
}

