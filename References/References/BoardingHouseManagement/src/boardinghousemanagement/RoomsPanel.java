/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class RoomsPanel extends javax.swing.JPanel {

    
    public RoomsPanel() {
        initComponents();
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
 
        frame_.setTitle("Rooms Management - Saligumba Boarding House Management");
        frame_.setDefaultCloseOperation(0);
        
        updateTable();
        roomLetter = roomLetterCombo.getSelectedItem().toString();
        state = stateCombo.getSelectedItem().toString();
        boarderNum = "0";
    }

    private void reset() {
        roomLetterCombo.setSelectedIndex(0);
        roomLetter = roomLetterCombo.getSelectedItem().toString();
        setRoomID(roomLetter);
        descriptionText.setText("");
        deckText.setText("");
        boarderNumText.setText("");
        spaceAvText.setText("");
        stateCombo.setSelectedIndex(0);
        state = stateCombo.getSelectedItem().toString();
        boarderNum = "0";
    }
    
    private void updateTable() {
        Rooms.updateRoomTable();
        roomsTable.setModel(Rooms.getTableModel());
    }
    
    private void setRoom() {
        roomID = roomsTable.getModel().getValueAt(roomsTable.getSelectedRow(), 0).toString();   
        Rooms.getRoom(roomID);
        
        roomLetterCombo.setSelectedItem(Rooms.getLetter());
        roomNumberText.setText(Rooms.getNum());
        descriptionText.setText(Rooms.getDesc());
        deckText.setText(Rooms.getDecks());
        spaceAvText.setText(Rooms.getSpaceAvailable());
        boarderNumText.setText(Rooms.getNumOfBoarders());
        stateCombo.setSelectedItem(Rooms.getState());
        
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }
    
    private void setRoomID(String letter) {
        String query = "SELECT MAX(RoomNo) FROM Rooms WHERE Category='"+letter+"';";
        int i = 0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                i = getRs().getInt(1);
            }
            
            if(i == 0) {
                i = 100;
            }
            else {
                i+=1;
            }
            
            roomNumberText.setText(""+i);
        }
        catch(Exception exception) {
            new Error("CANNOT INITIALIZED ROOM ID\n\nERROR: "+exception).showErrorDialog();
            roomNumberText.setText("100");
        }
        
        roomNum = roomNumberText.getText();
    }
    
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

    public static Connection getConnection() {
        return connection_;
    }

    public static void setConnection(Connection connection) {
        connection_ = connection;
    }

    public static PreparedStatement getPst() {
        return pst_;
    }

    public static void setPst(PreparedStatement pst) {
        pst_ = pst;
    }

    public static ResultSet getRs() {
        return rs_;
    }

    public static void setRs(ResultSet rs) {
        rs_ = rs;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roomLetterCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        descriptionText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        deckText = new javax.swing.JTextField();
        spaceAvText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roomNumberText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        boarderNumText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        stateCombo = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(760, 700));

        jLabel1.setText("Room NO.:");

        roomLetterCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C" }));
        roomLetterCombo.setEnabled(false);
        roomLetterCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomLetterComboActionPerformed(evt);
            }
        });

        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableMouseClicked(evt);
            }
        });
        roomsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomsTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(roomsTable);

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
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));

        descriptionText.setEnabled(false);
        descriptionText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionText)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Decks Available:");

        deckText.setEnabled(false);
        deckText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deckTextKeyReleased(evt);
            }
        });

        spaceAvText.setEnabled(false);
        spaceAvText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spaceAvTextKeyReleased(evt);
            }
        });

        jLabel3.setText("Boarder Space Available:");

        jLabel4.setText("-");

        roomNumberText.setEnabled(false);

        jLabel5.setText("No. of Boarders:");

        boarderNumText.setEnabled(false);
        boarderNumText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boarderNumTextKeyReleased(evt);
            }
        });

        jLabel6.setText("Current State:");

        stateCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Full" }));
        stateCombo.setEnabled(false);
        stateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deckText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spaceAvText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boarderNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomLetterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roomNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(roomLetterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deckText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(spaceAvText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(boarderNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableMouseClicked
        setRoom();
    }//GEN-LAST:event_roomsTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        saveButton.setEnabled(true);
        editButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        addButton.setEnabled(false);
        
        roomLetterCombo.setEnabled(true);
        descriptionText.setEnabled(true);
        deckText.setEnabled(true);
        spaceAvText.setEnabled(true);
        boarderNumText.setEnabled(true);
        stateCombo.setEnabled(true);
        
        roomsTable.setEnabled(false);
        roomsTable.clearSelection();
        
        isAdd = true;
        
        reset();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        roomLetter = roomLetterCombo.getSelectedItem().toString();
        roomNum = roomNumberText.getText();
        roomDesc = descriptionText.getText();
        decks = deckText.getText();
        spaceAv = spaceAvText.getText();
        state = stateCombo.getSelectedItem().toString();
        
        if(isAdd == true) {
            if(deckText.getText().isEmpty() == false || spaceAvText.getText().isEmpty() == false || boarderNumText.getText().isEmpty() == false) {
                new Rooms(roomLetter, roomNum, roomDesc, decks, spaceAv, boarderNum, state).addRoom();
                
                isAdd = !isAdd;
                reset();
                addButton.setEnabled(true);
                saveButton.setEnabled(false);
                roomsTable.setEnabled(true);
                roomsTable.clearSelection();
                
                roomLetterCombo.setEnabled(false);
                roomNumberText.setEnabled(false);
                descriptionText.setEnabled(false);
                deckText.setEnabled(false);
                spaceAvText.setEnabled(false);
                boarderNumText.setEnabled(false);
                stateCombo.setEnabled(false);
            }
            else {
                new Error("Complete data first.").showErrorDialog();
            }
        }
        else if(isEdit) {
            new Rooms(roomLetter, roomNum, roomDesc, decks, spaceAv, boarderNum, state).updateRoom(roomID);
            
            isEdit = !isEdit;
            reset();
            addButton.setEnabled(true);
            saveButton.setEnabled(false);
            roomsTable.setEnabled(true);
            roomsTable.clearSelection();
            
            roomLetterCombo.setEnabled(false);
            roomNumberText.setEnabled(false);
            descriptionText.setEnabled(false);
            deckText.setEnabled(false);
            spaceAvText.setEnabled(false);
            boarderNumText.setEnabled(false);
            stateCombo.setEnabled(false);
        }
        
        updateTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Rooms.deleteRoom(roomID);
        
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        addButton.setEnabled(true);

        reset();
        updateTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        editButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        addButton.setEnabled(false);
        
        roomLetterCombo.setEnabled(true);
        descriptionText.setEnabled(true);
        deckText.setEnabled(true);
        spaceAvText.setEnabled(true);
        boarderNumText.setEnabled(true);
        stateCombo.setEnabled(true);
        
        roomsTable.setEnabled(false);
        roomsTable.clearSelection();
        
        isEdit = true;
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(isAdd == true || isEdit == true) {
            saveButton.setEnabled(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
            addButton.setEnabled(true);
        
            roomLetterCombo.setEnabled(false);
            descriptionText.setEnabled(false);
            deckText.setEnabled(false);
            spaceAvText.setEnabled(false);
            boarderNumText.setEnabled(false);
            stateCombo.setEnabled(false);
        
            roomsTable.setEnabled(true);
            roomsTable.clearSelection();
            
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
        
        reset();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void roomLetterComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomLetterComboActionPerformed
        roomLetter = roomLetterCombo.getSelectedItem().toString();
        setRoomID(roomLetter);
    }//GEN-LAST:event_roomLetterComboActionPerformed

    private void descriptionTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTextKeyReleased
        roomDesc = descriptionText.getText();
    }//GEN-LAST:event_descriptionTextKeyReleased

    private void deckTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deckTextKeyReleased
        try {
            decks = deckText.getText();
            spaceAv = String.valueOf(Integer.parseInt(decks)*2);
        }
        catch(NumberFormatException exception) {
            deckText.setText("");
            decks = deckText.getText();
            spaceAv = String.valueOf(0*2);
        }
        spaceAvText.setText(""+spaceAv);
    }//GEN-LAST:event_deckTextKeyReleased

    private void spaceAvTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spaceAvTextKeyReleased
        try {
            spaceAv = spaceAvText.getText();
        }
        catch(NumberFormatException exception) {
            spaceAvText.setText("");
            spaceAv = "0";
        }
    }//GEN-LAST:event_spaceAvTextKeyReleased

    private void boarderNumTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boarderNumTextKeyReleased
        try {
            boarderNum = boarderNumText.getText();
        }
        catch(NumberFormatException excpetion) {
            boarderNumText.setText("");
            boarderNum = "0";
        }
    }//GEN-LAST:event_boarderNumTextKeyReleased

    private void stateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboActionPerformed
        state = stateCombo.getSelectedItem().toString();
    }//GEN-LAST:event_stateComboActionPerformed

    private void roomsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomsTableKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_UP) || (evt.getKeyCode()==KeyEvent.VK_DOWN)) {
            setRoom();
        }
    }//GEN-LAST:event_roomsTableKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField boarderNumText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField deckText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionText;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox roomLetterCombo;
    private javax.swing.JTextField roomNumberText;
    private javax.swing.JTable roomsTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField spaceAvText;
    private javax.swing.JComboBox stateCombo;
    // End of variables declaration//GEN-END:variables

    private static JFrame frame_;
    private static Container container_;
    
    private String roomID;
    private String roomLetter;
    private String roomNum;
    private String roomDesc;
    private String decks;
    private String spaceAv;
    private String boarderNum;
    private String state;
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
    
    private boolean isEdit = false;
    private boolean isAdd = false;
}
