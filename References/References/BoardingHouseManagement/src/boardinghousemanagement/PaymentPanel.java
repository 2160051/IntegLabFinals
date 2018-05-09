/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class PaymentPanel extends javax.swing.JPanel {

    
    public PaymentPanel() {
        initComponents();
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
        
        getFrame().setDefaultCloseOperation(0);
        getFrame().setTitle("Payments - Saligumba Boarding House Management");
        frame.setDefaultCloseOperation(0);
        
        boarderTable.setModel(Payment.getPaymentTable());
        
        dateFormatter = new SimpleDateFormat("MMMM dd, yyyy EE");
        date = dateFormatter.format(new Date());
        dateText.setText(date);
    }

    private void reset() {
        idText.setText("");
        image.setIcon(null);
        nameText.setText("");
        addressText.setText("");
        rentDateText.setText("");
        rentAmountText.setText("");
        penaltyText.setText("");
        totalText.setText("");
        
        saveButton.setEnabled(false);
        
        boarderTable.clearSelection();
    }
    
    private void setBoarder() {
        boarderID = boarderTable.getModel().getValueAt(boarderTable.getSelectedRow(), 0).toString();   
        Boarder.getBoarder(boarderID);
        
        idText.setText(Boarder.getBoarderID());
        nameText.setText(Boarder.getFullName());
        addressText.setText(Boarder.getAddress());
        picPath = new File(Boarder.getPicPath());
        date = Payment.getRentalDate(boarderID);
        rentDateText.setText(Payment.getRentalDate(boarderID));
        Payment.getRental(boarderID);
        rentAmountText.setText(Payment.getRentAmount());
        penaltyText.setText(String.format("%.2f", 
                Double.parseDouble(Payment.computePenalty(rentDateText.getText()))));
        
        Double total;
        total = Double.parseDouble(rentAmountText.getText()) + Double.parseDouble(penaltyText.getText());
        totalText.setText(String.format("%.2f", total));
        
        try {
            Calendar now = Calendar.getInstance();
            Calendar sd = Calendar.getInstance();
                    
            Date d = new SimpleDateFormat("MMMM dd, yyyy").parse(date);
            sd.setTime(d);
            sd.add(Calendar.MONTH, 1);
            
            
            if(now.after(sd)) {
                saveButton.setEnabled(true);
            }
            else {
                saveButton.setEnabled(false);
            }
        }
        catch(Exception exception) {
            
        }
        
        setPic(picPath);
    }
    
    private void setPic(File url) {
        try
        {
            ImageIcon icon = new ImageIcon(url.toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            image.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        image = new javax.swing.JLabel();
        idText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addressText = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rentDateText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rentAmountText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        penaltyText = new javax.swing.JTextField();
        totalText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        boarderTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        dateText = new javax.swing.JLabel();

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        image.setBounds(0, 0, 160, 160);
        jLayeredPane1.add(image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        idText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        idText.setForeground(new java.awt.Color(153, 153, 0));
        idText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        nameText.setEditable(false);
        nameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        addressText.setEditable(false);
        addressText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addressText)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addressText, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Rental"));

        jLabel1.setText("Last Payment:");

        rentDateText.setEditable(false);
        rentDateText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Rental:");

        rentAmountText.setEditable(false);
        rentAmountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Penalty:");

        penaltyText.setEditable(false);
        penaltyText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        totalText.setEditable(false);
        totalText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Total Rental:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rentDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(penaltyText, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(rentAmountText))
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(totalText)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(rentAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(rentDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(penaltyText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        boarderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boarderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boarderTableMouseClicked(evt);
            }
        });
        boarderTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boarderTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(boarderTable);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        saveButton.setText("SUBMIT PAYMENT");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateText.setForeground(new java.awt.Color(153, 153, 0));
        dateText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateText.setText("jLabel4");
        dateText.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        boarderID = idText.getText();
        String rateID = Payment.getRateID();
        String penalty = penaltyText.getText();
        
        Payment.addPayment(boarderID, rateID, penalty);
        
        reset();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setContainer(getFrame().getContentPane());
        getContainer().setLayout(new BorderLayout());
        
        MainPanel mainPanel = new MainPanel();
        
        getContainer().remove(0);
        getContainer().add(mainPanel);
        getContainer().validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void boarderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boarderTableMouseClicked
        setBoarder();
    }//GEN-LAST:event_boarderTableMouseClicked

    private void boarderTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boarderTableKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_UP) || (evt.getKeyCode()==KeyEvent.VK_DOWN)) {
            setBoarder();
        }
    }//GEN-LAST:event_boarderTableKeyReleased

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        PaymentPanel.frame = frame;
    }

    public static Container getContainer() {
        return container;
    }

    public static void setContainer(Container container) {
        PaymentPanel.container = container;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressText;
    private javax.swing.JTable boarderTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateText;
    private javax.swing.JLabel idText;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField penaltyText;
    private javax.swing.JTextField rentAmountText;
    private javax.swing.JTextField rentDateText;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
    private String boarderID;
    private File picPath;
    
    private static JFrame frame;
    private static Container container;
    private String date;
    private SimpleDateFormat dateFormatter;
}
