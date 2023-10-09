/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryoumen_kyoma
 */
public class TokensIdentificados extends javax.swing.JPanel {

    public TokensIdentificados() {
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

    public void actualizarTabla(List<List<Object>> datos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Borra todas las filas existentes en la tabla

        for (List<Object> fila : datos) {
            model.addRow(fila.toArray()); // Agrega los nuevos datos a la tabla
        }
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
