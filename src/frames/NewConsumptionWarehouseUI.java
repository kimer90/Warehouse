/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import entities.ConsumptionWarehouse;
import entities.Facility;
import entities.Goods;
import entities.GoodsInWarehouse;
import entities.Warehouses;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import warehouse.Data;
import warehouse.WarInterface;
import warehouse.Warehouse;

/**
 *
 * @author Karelin
 */
public class NewConsumptionWarehouseUI extends javax.swing.JFrame {
    private JComboBox goodsBox;
    private JComboBox facilBox;
    private TableColumn goodsColumn;
    /**
     * Creates new form NewConsumptionWarehouseUI
     */
    public NewConsumptionWarehouseUI() {
        initComponents();
        setLocationRelativeTo(null);
        jLabel1.setText("Выбранный склад: " + MainUI.getSelectedPoint());
        goodsColumn = jTable1.getColumnModel().getColumn(0);
        goodsBox = new JComboBox();
        goodsColumn.setCellEditor(new DefaultCellEditor(goodsBox));
        for (GoodsInWarehouse giw : MainUI.getGiwlist()) 
            {
                if ((giw.getPointsId().getName()).equals(MainUI.getSelectedPoint()))
                {goodsBox.addItem(giw.getGoodsId().getName());}
            }
        goodsColumn = jTable1.getColumnModel().getColumn(3);
        facilBox = new JComboBox();
        goodsColumn.setCellEditor(new DefaultCellEditor(facilBox));
        for (Facility facil : MainUI.getFacillist())
            {facilBox.addItem(facil.getName());}
        jTable1.getModel().setValueAt(MainUI.getSelectedPoint(), 0, 1);
        AutoCompleteDecorator.decorate(goodsBox);
        AutoCompleteDecorator.decorate(facilBox);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null}
            },
            new String [] {
                "Наименование товара", "Склад", "Количество", "Объект", "№ документа"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Добавить строку");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Отмена");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Отправить товар");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jButton4.setText("Удалить строку");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(243, 243, 243)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"", MainUI.getSelectedPoint()});
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Data data = new Data();
        data.setOperation(11);
        List<Object> list = new ArrayList<Object>();
        for (int i =0; i < jTable1.getModel().getRowCount(); i++)
        {
            try
            {
                if (((String)jTable1.getModel().getValueAt(i, 0)).equals("") ||
                    ((String)jTable1.getModel().getValueAt(i, 1)).equals("") ||
                    jTable1.getModel().getValueAt(i, 2) == null ||
                    ((String)jTable1.getModel().getValueAt(i, 3)).equals("") ||
                    ((String)jTable1.getModel().getValueAt(i, 4)).equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Заполните все поля.");
                    break;
                }
                else if ((Integer)jTable1.getModel().getValueAt(i, 2) <= 0)
                {
                    JOptionPane.showMessageDialog(null, "Недопустимое колличество.");
                    break;
                }
                else
                {
                    ConsumptionWarehouse con = new ConsumptionWarehouse();
                    for (Goods goods : MainUI.getGoodslist())
                    {
                        if (goods.getName().equals((String)jTable1.getModel().getValueAt(i, 0)))
                        {con.setGoodsId(goods); System.err.println(goods.getId());}
                    }
                    for (Warehouses war : MainUI.getWarlist())
                    {
                        if (war.getName().equals((String)jTable1.getModel().getValueAt(i, 1)))
                        {con.setActivePointId(war); System.err.println(war.getId());}
                    }
                    con.setAmount(-1*((Integer)jTable1.getModel().getValueAt(i, 2)));
                    con.setTime(new Date());
                    for (Facility facil : MainUI.getFacillist())
                    {
                        if (facil.getName().equals((String)jTable1.getModel().getValueAt(i, 3)))
                        {con.setPassivePointId(facil); System.err.println(facil.getId());}
                    }
                    con.setDocumentNumber((String)jTable1.getModel().getValueAt(i, 4));
                    list.add(con);
                    if (i == jTable1.getModel().getRowCount() - 1)
                    {
                        int m = JOptionPane.showConfirmDialog(null, "Внести изменения в БД?",
                            "Внимание", JOptionPane.YES_NO_OPTION);
                        if (m == JOptionPane.YES_OPTION)
                        {
                            data.setValues(list);
                            Warehouse war = new Warehouse();
                            if (war.connect() == WarInterface.OK)
                            {
                                war.run(data);
                                war.disconnect();
                            }
                            Data test = war.getTest();
                            if (test.getOperation() == 0)
                            {
                                JOptionPane.showMessageDialog(null, "Данные успешно внесены.");
                                dispose();
                                MainUI.getCatalog();
                            }
                            else if (test.getOperation() == 1)
                            {
                                ConsumptionWarehouse amounterr = (ConsumptionWarehouse)test.getValues().get(0);
                                JOptionPane.showMessageDialog(null, "Недостаточное количество товара: " + 
                                        amounterr.getGoodsId().getName() + ". Доступно: " + amounterr.getAmount());
                            }
                            else if (test.getOperation() == -1)
                            {JOptionPane.showMessageDialog(null, "Ошибка при внесении данных.");}
                        }
                    }
                }                
            }
            catch (NullPointerException ex)
            {
                System.err.println("Error-> " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Заполните все поля.");
                break;
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() != -1)
        {model.removeRow(jTable1.getSelectedRow());}
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}