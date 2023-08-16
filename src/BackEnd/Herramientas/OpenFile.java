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
}

