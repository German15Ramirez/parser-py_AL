/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import BackEnd.Herramientas.*;
import BackEnd.Herramientas.NumeracionColumnas;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ryoumen_kyoma
 */
public class EntornoVisual extends javax.swing.JFrame {

    public static TokensIdentificados tokensIdentificados;
    private String text;
    private final NumeracionFilas numeroFilaC1;
    public static HashMap<Object, Object> mapTokens;
    public static List<List<Object>> infoTabla = new ArrayList<>();
    public static List<List<Object>> tablaToken = new ArrayList<>();
    public static List<Object> newList = new ArrayList<>();
    public static List<List<Object>> newListOfLists = new ArrayList<>();

    /**
     * Creates new form VisualForm
     */
    public EntornoVisual() {
        initComponents();
        numeroFilaC1 = new NumeracionFilas(jTextPane1);
        jScrollPane1.setRowHeaderView(numeroFilaC1);
        NumeracionColumnas numeracionColumnas = new NumeracionColumnas(jTextPane1, jLabel3);
        mapTokens = new HashMap<>();
        tokensIdentificados = new TokensIdentificados();
        tokensIdentificados.setVisible(true);
    }

    public static TokensIdentificados getTokensIdentificados() {
        return tokensIdentificados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("parser-py_AL");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        jButton2.setText("Generar Grafico");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 30));

        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 90, 30));

        jButton4.setText("Acerca de");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 110, 30));

        jButton5.setBackground(new java.awt.Color(0, 204, 0));
        jButton5.setFont(new java.awt.Font("Bitstream Charter", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Ejecutar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, -1, -1));

        jTextPane1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 800));

        jLabel3.setBackground(new java.awt.Color(0, 255, 255));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Columna = ");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jButton6.setText("Reportes Y Mas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/binary-code-background-digital-binary-data-with-streaming-digital-code-futuristic-cyberspace_1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 890));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "Este programa es un analizador de código basado en phyton, conforme pase el tiempo, se haran actualizaciones complentandolo hasta que sea un compilador basico");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OpenFile.openFileAndSetText(jTextPane1);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AnalisisLexico analyzer = new AnalisisLexico(jTextPane1.getText());
        try {
            analyzer.analyze();
        } catch (IOException ex) {
            Logger.getLogger(EntornoVisual.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<Object, Object> mapTokens = analyzer.getMapTokens();
        infoTabla = analyzer.getInfoTabla();
        tablaToken = analyzer.getTablaToken();
        // Borra el contenido actual de newListOfLists
        newListOfLists.clear();

        for (List<Object> tabla : tablaToken) {
            List<Object> newList = new ArrayList<>(tabla);
            newListOfLists.add(newList);
        }
        resaltarSintaxis();
        System.out.println("Tokens del Lexico : " + infoTabla);
        actualizarTablaEnTokensIdentificados();
    }//GEN-LAST:event_jButton5ActionPerformed

    public void resaltarSintaxis() {
        StyledDocument doc = jTextPane1.getStyledDocument();
        String text = jTextPane1.getText();
        ColoreoTokens.colorPalabras(doc, text, newListOfLists);
    }

    public void actualizarTablaEnTokensIdentificados() {
        if (tokensIdentificados != null) {
            tokensIdentificados.actualizarTabla(infoTabla);
        } else {
            System.err.println("TokensIdentificados no está inicializado.");
        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int choice = JOptionPane.showOptionDialog(
                null,
                "¿Deseas ir al tutorial?",
                "Opción",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Ir al tutorial", "Cerrar"},
                "Ir al tutorial"
        );

        if (choice == JOptionPane.YES_OPTION) {
            try {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI("https://youtu.be/miInS1-qfk4"));
                } else {
                    JOptionPane.showMessageDialog(null, "Abre el siguiente enlace en tu navegador:\nhttps://youtu.be/miInS1-qfk4");
                }
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        JFrame reportesFrame = new JFrame("Reportes");
        Reportes reportesPanel = new Reportes();
        reportesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportesFrame.getContentPane().add(reportesPanel);
        reportesFrame.pack();
        reportesFrame.setLocationRelativeTo(null);
        reportesFrame.setResizable(false); // Bloquea la opción de maximizar
        reportesFrame.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntornoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntornoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntornoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntornoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntornoVisual().setVisible(true);
            }

        });
        TokensIdentificados tokensIdentificados = new TokensIdentificados();

        tokensIdentificados.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
