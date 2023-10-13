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
public class TokensIdentificados extends javax.swing.JPanel {

    private List<List<Object>> tokenData;
    private List<List<Object>> originalTokenData;
    private DefaultTableModel model;

    public TokensIdentificados() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"TIPO", "TOKEN", "PATRON", "LEXEMA", "FILA", "COLUMNA"}
        );
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        JButton filtroIdentificador = new JButton("Identificador");
        JButton filtroPalabraReservada = new JButton("Palabra Reservada");
        JButton mostrarTodo = new JButton("Mostrar Todo");
        JButton filtroAritmetico = new JButton("Aritmetico");
        JButton filtroAsignacion = new JButton("Asignacion");
        JButton filtroBooleanas = new JButton("Booleanas");
        JButton filtroComentario = new JButton("Comentario");
        JButton filtroComparacion = new JButton("Comparacion");
        JButton filtroConstante = new JButton("Constante");
        JButton filtroLogico = new JButton("Logico");
        JButton filtroOtro = new JButton("Otro");

        filtroIdentificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeIdentificador");
            }
        });
        filtroOtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeOtro");
            }
        });
        filtroPalabraReservada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypePalabraReservada");
            }
        });

        // Agregar acciones para los otros tipos
        filtroAritmetico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeAritmetico");
            }
        });

        filtroAsignacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeAsignacion");
            }
        });

        filtroBooleanas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeBooleanas");
            }
        });

        filtroComentario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeComentario");
            }
        });

        filtroComparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeComparacion");
            }
        });

        filtroConstante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeConstante");
            }
        });

        filtroLogico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarTablaPorTipo("TypeLogico");
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
                                .addComponent(filtroIdentificador)
                                .addComponent(filtroPalabraReservada)
                                .addComponent(filtroAritmetico)
                                .addComponent(filtroAsignacion)
                                .addComponent(filtroBooleanas)
                                .addComponent(filtroComentario)
                                .addComponent(filtroComparacion)
                                .addComponent(filtroConstante)
                                .addComponent(filtroLogico)
                                
                                .addComponent(filtroOtro)
                        )
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mostrarTodo)
                                        .addComponent(filtroIdentificador)
                                        .addComponent(filtroPalabraReservada)
                                        .addComponent(filtroAritmetico)
                                        .addComponent(filtroAsignacion)
                                        .addComponent(filtroBooleanas)
                                        .addComponent(filtroComentario)
                                        .addComponent(filtroComparacion)
                                        .addComponent(filtroConstante)
                                        .addComponent(filtroLogico)
                                        
                                        .addComponent(filtroOtro)
                                )
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                        )
        );
    }

    public void actualizarTabla(List<List<Object>> tokenList) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Borra todas las filas existentes en la tabla

        for (List<Object> fila : tokenList) {
            model.addRow(fila.toArray()); // Agrega los nuevos datos a la tabla
        }

        // Asigna los datos a la variable tokenData
        tokenData = tokenList;
        originalTokenData = tokenList;

    }

    private void filtrarTablaPorTipo(String tipo) {
        DefaultTableModel newModel = new DefaultTableModel(
                new Object[]{"TIPO", "TOKEN", "PATRON", "LEXEMA", "FILA", "COLUMNA"},
                0
        );

        for (List<Object> fila : tokenData) {
            String tipoToken = fila.get(0).toString();
            if (tipoToken.equals(tipo)) {
                newModel.addRow(fila.toArray());
            }
        }

        jTable1.setModel(newModel);
    }

    private void mostrarContenidoOriginal() {
        DefaultTableModel originalModel = new DefaultTableModel(
                new Object[]{"TIPO", "TOKEN", "PATRON", "LEXEMA", "FILA", "COLUMNA"},
                0
        );

        for (List<Object> fila : originalTokenData) {
            originalModel.addRow(fila.toArray());
        }

        jTable1.setModel(originalModel);
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
