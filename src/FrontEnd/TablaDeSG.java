/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryoumen_kyoma
 */
public class TablaDeSG extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloOriginal;

    public TablaDeSG() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        modeloTabla = new DefaultTableModel(
                new Object[][]{},
                new String[]{"DESCRIPCION"}
        );
        modeloOriginal = modeloTabla; // Guarda una copia del modelo original
        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        JButton filtroOperadoresTernarios = new JButton("Operadores Ternarios");
        JButton filtroDeclaracionVariables = new JButton("Declaración de Variables");
        JButton filtroCicloFor = new JButton("Ciclo For");
        JButton filtroCicloWhile = new JButton("Ciclo While");
        JButton filtroDefinicionFuncion = new JButton("Definición de Función");
        JButton filtroComentarios = new JButton("Comentarios");
        JButton mostrarTodo = new JButton("Mostrar Todo");

        filtroOperadoresTernarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Operador ternario #");
            }
        });
        filtroDeclaracionVariables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Declaración de Variable #");
            }
        });
        filtroCicloFor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Ciclo For #");
            }
        });
        filtroCicloWhile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Ciclo While #");
            }
        });
        filtroDefinicionFuncion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Definición de Función #");
            }
        });
        filtroComentarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo(" Comentario #");
            }
        });
        mostrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarContenidoOriginal();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mostrarTodo)
                                .addComponent(filtroOperadoresTernarios)
                                .addComponent(filtroDeclaracionVariables)
                                .addComponent(filtroCicloFor)
                                .addComponent(filtroCicloWhile)
                                .addComponent(filtroDefinicionFuncion)
                                .addComponent(filtroComentarios)
                        )
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mostrarTodo)
                                        .addComponent(filtroOperadoresTernarios)
                                        .addComponent(filtroDeclaracionVariables)
                                        .addComponent(filtroCicloFor)
                                        .addComponent(filtroCicloWhile)
                                        .addComponent(filtroDefinicionFuncion)
                                        .addComponent(filtroComentarios)
                                )
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                        )
        );
    }

    public void actualizarTabla(List<String> impresiones) {
        modeloTabla.setRowCount(0);

        for (String impresion : impresiones) {
            String[] partes = impresion.split(";");
            modeloTabla.addRow(partes);
        }
    }

    private void filtrarTablaPorTipo(String tipo) {
        DefaultTableModel newModel = new DefaultTableModel(
                new Object[]{"DESCRIPCION"},
                0
        );

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String descripcion = modeloTabla.getValueAt(i, 0).toString();
            if (descripcion.startsWith(tipo)) {
                newModel.addRow(new Object[]{descripcion});
            }
        }

        jTable1.setModel(newModel);
    }

    private void mostrarContenidoOriginal() {
        jTable1.setModel(modeloOriginal); // Restablece la tabla con el modelo original
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
