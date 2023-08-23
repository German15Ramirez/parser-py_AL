/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author ryoumen_kyoma
 */
public class OpenFile {
    public static void openFileAndSetText(JTextPane jTextPane) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null); // Cambiar a tu JFrame si es necesario
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            loadTxtFile(selectedFile, jTextPane);
        }
    }

    public static void loadTxtFile(File file, JTextPane jTextPane) {
        try {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            jTextPane.setText(content.toString());

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static String cleanAndNormalizeCode(String input) {
    // Dividir el contenido en líneas
    String[] lines = input.split("\\r?\\n");
    
    // Eliminar espacios en blanco excesivos y ajustar la indentación
    StringBuilder cleanedContent = new StringBuilder();
    int minIndent = Integer.MAX_VALUE;

    for (String line : lines) {
        String trimmedLine = line.trim();
        if (!trimmedLine.isEmpty()) {
            int indent = line.length() - trimmedLine.length();
            minIndent = Math.min(minIndent, indent);
        }
    }

    for (String line : lines) {
        String trimmedLine = line.trim();
        if (!trimmedLine.isEmpty()) {
            cleanedContent.append(line.substring(minIndent)).append("\n");
        }
    }

    return cleanedContent.toString();
}
}

