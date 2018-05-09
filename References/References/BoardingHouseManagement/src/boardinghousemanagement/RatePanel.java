/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class RatePanel extends javax.swing.JPanel {

    public RatePanel() {
        initComponents();
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
        getFrame().setTitle("Manage Rate - Saligumba Boarding House Management");
        frame_.setDefaultCloseOperation(0);
        
        setRateTable();
    }
    
    private void reset() {
        typeText.setText("");
        amountText.setText("");
        descText.setText("");
    }
    
    private void setRate() {
        rateID = rateTable.getModel().getValueAt(rateTable.getSelectedRow(), 0).toString();   
        Rate.getRate(rateID);
        
        typeText.setText(Rate.getType());
        amountText.setText(Rate.getAmount());
        descText.setText(Rate.getDesc());
        
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    private void setRateTable() {
        Rate.updateRateTable();
        rateTable.setModel(Rate.getTableModel());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rateTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        typeText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        amountText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        descText = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(760, 700));

        rateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rateTableMouseClicked(evt);
            }
        });
        rateTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rateTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(rateTable);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        editButton.setText("EDIT");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        saveButton.setText("SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Type"));

        typeText.setEnabled(false);
        typeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Amount"));

        amountText.setEnabled(false);
        amountText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountTextFocusLost(evt);
            }
        });
        amountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));

        descText.setEnabled(false);
        descText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descText)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        saveButton.setEnabled(true);
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        typeText.setEnabled(true);
        amountText.setEnabled(true);
        descText.setEnabled(true);
        
        rateTable.setEnabled(false);
        rateTable.clearSelection();
        
        isAdd = true;
        
        reset();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        type = typeText.getText();
        amount = amountText.getText();
        desc = descText.getText();
        
        if(typeText.getText().equals("") || amountText.getText().equals("") || descText.getText().equals("")) {
            new Error("Complete Data First").showErrorDialog();
        }
        else {
            if(isAdd == true) {
                new Rate(type, amount, desc).addRate();
                
                isAdd = !isAdd;
            }
            else if(isEdit == true) {
                new Rate(type, amount, desc).updateRate(rateID);
                
                isEdit = !isEdit;
            }
            
            reset();
            
            saveButton.setEnabled(false);
            addButton.setEnabled(true);
            editButton.setEnabled(false);
            
            typeText.setEnabled(false);
            amountText.setEnabled(false);
            descText.setEnabled(false);
            
            rateTable.setEnabled(true);
            rateTable.clearSelection();
        }
        
        setRateTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        editButton.setEnabled(false);
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        typeText.setEnabled(true);
        amountText.setEnabled(true);
        descText.setEnabled(true);
        
        rateTable.setEnabled(false);
        rateTable.clearSelection();
        
        isEdit = true;
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Rate.deleteRate(rateID);
        
        addButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        rateTable.setEnabled(true);
        rateTable.clearSelection();
        
        reset();
        
        setRateTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(isAdd == true || isEdit == true) {
            saveButton.setEnabled(false);
            addButton.setEnabled(true);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        
            typeText.setEnabled(false);
            amountText.setEnabled(false);
            descText.setEnabled(false);
            
            rateTable.setEnabled(true);
            rateTable.clearSelection();
        
            isEdit = false;
            isAdd = false;
        }
        else {
            setContainer(frame_.getContentPane());
            container_.setLayout(new BorderLayout());
        
            AdminPanel adminPanel = new AdminPanel();
            adminPanel.setOpaque(true);
                
            container_.remove(0);
            container_.add(adminPanel);
            container_.validate();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void rateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rateTableMouseClicked
        setRate();
        
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_rateTableMouseClicked

    private void rateTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateTableKeyReleased
         if((evt.getKeyCode()==KeyEvent.VK_UP) || (evt.getKeyCode()==KeyEvent.VK_DOWN)) {
            setRate();
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_rateTableKeyReleased

    private void amountTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTextFocusLost
        try{
            amountText.setText(String.format("%.2f", Double.parseDouble(amountText.getText())));
            amount = amountText.getText();
        }
        catch(NumberFormatException exception) {
            amountText.setText("");
        }
    }//GEN-LAST:event_amountTextFocusLost

    private void typeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeTextKeyReleased
        type = typeText.getText();
    }//GEN-LAST:event_typeTextKeyReleased

    private void descTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTextKeyReleased
        desc = descText.getText();
    }//GEN-LAST:event_descTextKeyReleased

    private void amountTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTextKeyReleased
        try {
            int a = Integer.parseInt(amountText.getText());
        }
        catch(NumberFormatException exception) {
            amountText.setText("");
        }
    }//GEN-LAST:event_amountTextKeyReleased

    public static JFrame getFrame() {
        return frame_;
    }

    public static void setFrame(JFrame frame) {
        frame_ = frame;
    }

    public static Container getContainer() {
        return container_;
    }

    public static void setContainer(Container container) {
        container_ = container;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField amountText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descText;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rateTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField typeText;
    // End of variables declaration//GEN-END:variables
    private String type;
    private String amount;
    private String desc;
    private String rateID;
    
    private boolean isAdd;
    private boolean isEdit;
    
    private static JFrame frame_;
    private static Container container_;
}
