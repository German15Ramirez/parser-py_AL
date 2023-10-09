/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author ryoumen_kyoma
 */
public class Reportes extends javax.swing.JPanel {
     public Reportes() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setName("");

        jButton1.setText("Tabla de Simbolos Global");
        jButton2.setText("Tabla de Simbolos por Bloque de Codigo");
        jButton3.setText("Lista de Instrucciones por Bloque de Codigo");
        jButton4.setText("Cantidad de Funciones o Metodos");
        jButton5.setText("Errores Lexicos");
        jButton6.setText("Errores Sintacticos");
        jButton7.setText("Cantidad de Veces que se Llame una Funcion o Metodo");
        jButton8.setText("Parametros de una funcion");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24));
        jLabel1.setText("REPORTES");

        jButton9.setText("Tokens Identificados");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new GridLayout(11, 1));
        jPanel1.add(jLabel1);
        jPanel1.add(jButton9);
        jPanel1.add(jButton5);
        jPanel1.add(jButton6);
        jPanel1.add(jButton8);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);
        jPanel1.add(jButton4);
        jPanel1.add(jButton7);

        setLayout(new BorderLayout());
        add(jPanel1, BorderLayout.CENTER);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        TokensIdentificados tokensFrame = EntornoVisual.getTokensIdentificados();
        JFrame frame = new JFrame("Tokens Identificados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(tokensFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}
