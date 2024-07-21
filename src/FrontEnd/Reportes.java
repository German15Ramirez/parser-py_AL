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
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setName("");

        jButton1.setText("Tabla de Simbolos Global, Cantidad de Funciones y No. de Llamadas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Tabla de Simbolos por Bloque de Codigo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("Lista de Instrucciones por Bloque de Codigo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton5.setText("Errores Lexicos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        }
        );
        jButton6.setText("Errores Sintacticos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton8.setText("Parametros de una funcion");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton9.setText("Tokens Identificados");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24));
        jLabel1.setText("REPORTES");

        jPanel1.setLayout(new GridLayout(9, 1));
        jPanel1.add(jLabel1);
        jPanel1.add(jButton9);
        jPanel1.add(jButton5);
        jPanel1.add(jButton1);
        jPanel1.add(jButton6);
        jPanel1.add(jButton8);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);

        setLayout(new BorderLayout());
        add(jPanel1, BorderLayout.CENTER);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la Tabla de Simbolos Global, Cantidad de Funciones y No. de Llamadas
        TablaDeSG tablaDeSGFrame = EntornoVisual.getTablaDeSG();
        JFrame frame = new JFrame("Tabla de Simbolos Global, Cantidad de Funciones y No. de Llamadas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(tablaDeSGFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la Tabla de Simbolos por Bloque de Codigo
        TablaDeSBC tablaDeSBCFrame = EntornoVisual.getTablaDeSBC();
        JFrame frame = new JFrame("Tabla de Simbolos por Bloque de Codigo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(tablaDeSBCFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la tabla de Lista de Instrucciones por Bloque de Codigo
        ListaDeInstruccionesBC listaDeInstruccionesBCFrame = EntornoVisual.getListaDeInstruccionesBC();
        JFrame frame = new JFrame("Lista de Instrucciones por Bloque de Codigo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(listaDeInstruccionesBCFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la tabla de errores léxicos
        ErroresLexicos erroresFrame = EntornoVisual.getErroresLexicos();
        JFrame frame = new JFrame("Errores Lexicos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(erroresFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la tabla de Errores Sintacticos
        ErroresSintacticos erroresSintacticosFrame = EntornoVisual.getErroresSintacticos();
        JFrame frame = new JFrame("Errores Sintacticos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(erroresSintacticosFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la tabla de Parametros de una funcion
        ParametrosDeUnaFuncion parametrosDeUnaFuncionFrame = EntornoVisual.getParametrosDeUnaFuncion();
        JFrame frame = new JFrame("Parametros de una funcion");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(parametrosDeUnaFuncionFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar la tabla de tokens identificados
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}
