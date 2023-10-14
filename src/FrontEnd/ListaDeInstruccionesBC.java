/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryoumen_kyoma
 */
public class ListaDeInstruccionesBC extends javax.swing.JPanel{
    public ListaDeInstruccionesBC() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"TOKENS", "PATRON", "LEXEMA", "FILA", "COLUMNA"}
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
