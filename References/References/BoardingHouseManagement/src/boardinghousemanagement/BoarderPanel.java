/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public final class BoarderPanel extends javax.swing.JPanel {
    
    public BoarderPanel() {
        initComponents();
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
        getFrame().setTitle("Add Boarder - Saligumba Boarding House Management");
        frame_.setDefaultCloseOperation(0);

        setRoomNoCombo(); 
        setID();
        setRateCombo();
        ID = idText.getText();
        roomNo = roomNoCombo.getSelectedItem().toString();
        status = statusCombo.getSelectedItem().toString();
        gender = genderCombo.getSelectedItem().toString();
        type = typeCombo.getSelectedItem().toString();
        
        try{
            malePicURL = new File("resources/male_no_image.png");
            femalePicURL = new File("resources/female_no_image.png");
        }
        catch(Exception exception){}
        
        setPic(malePicURL);
        getAmount(type);
    }
    
    private void getAmount(String type) {
        String query = "SELECT RateID, RateType, RateAmount FROM Rates WHERE RateType='"+type+"';";
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                rateID = getRs().getString("RateID");
                amountText.setText(""+getRs().getString("RateAmount"));
            }
            
        }
        catch(Exception exception) {
            new Error("Error getting Rate Amoun. \n\nERROR: "+exception).showErrorDialog();
        }
    }
    
    private void setPic(File url) {
        try
        {
            ImageIcon icon = new ImageIcon(url.toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            image.setIcon(icon2);
            
            picPath = url.toString();
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
    }
    
    private void setID() {
        String query = "SELECT MAX(BoarderID) FROM Boarders;";
        int i=0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(rs.next()) {
                i = rs.getInt(1);
            }
            
            if(i==0) {
                i=1001;
            }
            else {
                i+=1;
            }
            
            idText.setText(""+i);
        }
        catch(Exception exception) {
            new Error("CANNOT INITIALIZED BOARDER ID\n\nERROR:  "+exception).showErrorDialog();
            idText.setText("1001");
        }
    }
    
    private void setRoomNoCombo() {
        DefaultComboBoxModel dt = new DefaultComboBoxModel();
        
        dt.removeAllElements();
        
        int i = Rooms.getRoomList().size();
        int j;
        for(j=0;j<=(i-1);j++){
            dt.addElement(Rooms.getRoomList().get(j));
        }
        roomNoCombo.setModel(dt);
        roomNoCombo.revalidate();
    }

    private void setRateCombo() {
        int i = Rate.getRateList().size();
        int j;
        for(j=0;j<=(i-1);j++){
            typeCombo.addItem(Rate.getRateList().get(j));
        }
    }
    
    private void reset() {
        roomNoCombo.setSelectedIndex(0);
        setID();
        firstNameText.setText("");
        middleNameText.setText("");
        lastNameText.setText("");
        brgyText.setText("");
        townText.setText("");
        provText.setText("");
        statusCombo.setSelectedIndex(0);
        ageText.setText("");
        genderCombo.setSelectedIndex(0);
        setPic(malePicURL);
        pFNameText.setText("");
        pMNameText.setText("");
        pLNameText.setText("");
        typeCombo.setSelectedIndex(0);
        type = typeCombo.getSelectedItem().toString();
        getAmount(type);
    }
    
    public static JFrame getFrame() {
        return frame_;
    }

    public void setFrame(JFrame frame) {
        frame_ = frame;
    }

    public static Container getContainer() {
        return container_;
    }

    public void setContainer(Container container) {
        container_ = container;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picFileChooser = new javax.swing.JFileChooser();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        image = new javax.swing.JLabel();
        uploadPhotoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        firstNameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        middleNameText = new javax.swing.JTextField();
        lastNameText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        brgyText = new javax.swing.JTextField();
        townText = new javax.swing.JTextField();
        provText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        roomNoCombo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pFNameText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pMNameText = new javax.swing.JTextField();
        pLNameText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox();
        statusCombo = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        mobileText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        typeCombo = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        image.setBounds(0, 0, 160, 160);
        jLayeredPane1.add(image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        uploadPhotoButton.setText("Upload Photo");
        uploadPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPhotoButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Room #:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        firstNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstNameTextKeyReleased(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("First Name");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Middle Name");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Last Name");

        middleNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                middleNameTextKeyReleased(evt);
            }
        });

        lastNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastNameTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameText)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(middleNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        brgyText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brgyTextKeyReleased(evt);
            }
        });

        townText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                townTextKeyReleased(evt);
            }
        });

        provText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                provTextKeyReleased(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("St. / Brgy.");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Town");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Province");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(brgyText)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(townText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(provText, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brgyText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(townText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)))
        );

        roomNoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNoComboActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Parent / Guardian"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        pFNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pFNameTextKeyReleased(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("First Name");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Middle Name");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Last Name");

        pMNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pMNameTextKeyReleased(evt);
            }
        });

        pLNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pLNameTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pFNameText)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pMNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pLNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pFNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pMNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setText("Status:");

        jLabel24.setText("Age:");

        ageText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ageTextKeyReleased(evt);
            }
        });

        jLabel25.setText("Gender:");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        statusCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageText, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(genderCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Mobile No."));

        mobileText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mobileText)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mobileText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setText("ID:");

        idText.setEditable(false);
        idText.setOpaque(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Rental"));

        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });

        jLabel26.setText("Type:");

        jLabel9.setText("Amount:");

        amountText.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amountText))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uploadPhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roomNoCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(idText))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadPhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
    if(genderCombo.getSelectedItem().equals("Male")) {
        setPic(malePicURL);
    }
    else {
        setPic(femalePicURL);
    }
    
    gender = genderCombo.getSelectedItem().toString();
    }//GEN-LAST:event_genderComboActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        MainPanel mainPanel = new MainPanel();
        mainPanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(mainPanel);
        container_.validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed
        type = typeCombo.getSelectedItem().toString();
        getAmount(type);
    }//GEN-LAST:event_typeComboActionPerformed

    private void roomNoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNoComboActionPerformed
        roomNo = roomNoCombo.getSelectedItem().toString();
    }//GEN-LAST:event_roomNoComboActionPerformed

    private void firstNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTextKeyReleased
        fName = firstNameText.getText();
    }//GEN-LAST:event_firstNameTextKeyReleased

    private void middleNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middleNameTextKeyReleased
        mName = middleNameText.getText();
    }//GEN-LAST:event_middleNameTextKeyReleased

    private void lastNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTextKeyReleased
        lName = lastNameText.getText();
    }//GEN-LAST:event_lastNameTextKeyReleased

    private void brgyTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyTextKeyReleased
        brgy = brgyText.getText();
    }//GEN-LAST:event_brgyTextKeyReleased

    private void townTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_townTextKeyReleased
        town = townText.getText();
    }//GEN-LAST:event_townTextKeyReleased

    private void provTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provTextKeyReleased
        prov = provText.getText();
    }//GEN-LAST:event_provTextKeyReleased

    private void statusComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboActionPerformed
        status = statusCombo.getSelectedItem().toString();
    }//GEN-LAST:event_statusComboActionPerformed

    private void ageTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageTextKeyReleased
        try {
            age = ageText.getText();
        }
        catch(NumberFormatException exception) {
            ageText.setText("");
            age = "0";
        }
    }//GEN-LAST:event_ageTextKeyReleased

    private void mobileTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileTextKeyReleased
        mobile = mobileText.getText();
    }//GEN-LAST:event_mobileTextKeyReleased

    private void pFNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pFNameTextKeyReleased
        pFName = pFNameText.getText();
    }//GEN-LAST:event_pFNameTextKeyReleased

    private void pMNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pMNameTextKeyReleased
        pMName = pMNameText.getText();
    }//GEN-LAST:event_pMNameTextKeyReleased

    private void pLNameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pLNameTextKeyReleased
        pLName = pLNameText.getText();
    }//GEN-LAST:event_pLNameTextKeyReleased

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        roomNo = roomNoCombo.getSelectedItem().toString();
        ID = idText.getText();
        fName = firstNameText.getText();
        mName = middleNameText.getText();
        lName = lastNameText.getText();
        brgy = brgyText.getText();
        town = townText.getText();
        prov = provText.getText();
        mobile = mobileText.getText();
        age = ageText.getText();
        gender = genderCombo.getSelectedItem().toString();
        status = statusCombo.getSelectedItem().toString();
        type = typeCombo.getSelectedItem().toString();
        getAmount(type);
        pFName = pFNameText.getText();
        pMName = pMNameText.getText();
        pLName = pLNameText.getText();
        
        if(firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() || 
                townText.getText().isEmpty() || provText.getText().isEmpty()) {
            new Error("Complete Data First.").showErrorDialog();
        }
        else {
            new Boarder(roomNo, ID, fName, mName, lName, brgy, town, prov, mobile, age, gender, status, type, rateID, pFName, pMName, pLName, picPath).addBorder();
            Rooms.updateNoOfBoarders(roomNo);
            setRoomNoCombo();
            reset();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void uploadPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPhotoButtonActionPerformed
        picFileChooser = new JFileChooser("Upload Photo");
        File file;
        FileFilter fileFilter = new FileNameExtensionFilter("Image Files (*.png, *.jpg, *.gif, *.bmp)", ImageIO.getReaderFileSuffixes());
        
        picFileChooser.setAcceptAllFileFilterUsed(false);
        picFileChooser.setFileFilter(fileFilter);
        int result = picFileChooser.showOpenDialog(getFrame());
        
        if(result == JFileChooser.APPROVE_OPTION) {
            file = picFileChooser.getSelectedFile().getAbsoluteFile();
                      
            try{
                setPic(file);
            }
            catch(Exception exception){}
        }
    }//GEN-LAST:event_uploadPhotoButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        BoarderPanel.connection = connection;
    }

    public static PreparedStatement getPst() {
        return pst;
    }

    public static void setPst(PreparedStatement pst) {
        BoarderPanel.pst = pst;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        BoarderPanel.rs = rs;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageText;
    private javax.swing.JTextField amountText;
    private javax.swing.JTextField brgyText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JComboBox genderCombo;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JTextField middleNameText;
    private javax.swing.JTextField mobileText;
    private javax.swing.JTextField pFNameText;
    private javax.swing.JTextField pLNameText;
    private javax.swing.JTextField pMNameText;
    private javax.swing.JFileChooser picFileChooser;
    private javax.swing.JTextField provText;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox roomNoCombo;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox statusCombo;
    private javax.swing.JTextField townText;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JButton uploadPhotoButton;
    // End of variables declaration//GEN-END:variables
    private static JFrame frame_;
    private static Container container_;
    
    private static Connection connection;
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    private String roomNo;
    private String ID;
    private String fName;
    private String mName;
    private String lName;
    private String brgy;
    private String town;
    private String prov;
    private String status;
    private String age;
    private String gender;
    private String mobile;
    private String pFName;
    private String pMName;
    private String pLName;
    private String type;
    private String rateID;
    private String picPath;
    
    private File malePicURL;
    private File femalePicURL;
}
