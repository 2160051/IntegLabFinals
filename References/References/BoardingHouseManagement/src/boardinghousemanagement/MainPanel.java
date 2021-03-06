/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author user
 */
public final class MainPanel extends javax.swing.JPanel {

    
    String INFO_STRING = "Select Action You Want!";
    
    public MainPanel() {
        super(new BorderLayout());
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
        getFrame().setTitle("Manage Boarder - Saligumba Boarding House Management");
        frame_.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        initComponents();
        
        setInfoString(INFO_STRING);
        
        try
        {
            ImageIcon icon = new ImageIcon(new File("resources/logo.png").toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            logo.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
        
        if(hasBoarders() == false) {
            viewBoarderButton.setEnabled(false);
            paymentButton.setEnabled(false);
        }
        else {
            viewBoarderButton.setEnabled(true);
            paymentButton.setEnabled(true);
        }
    }
    
    private boolean hasRooms() {
        String query = "SELECT RoomID FROM Rooms;";
        int i=0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                i++;
            }
            
            if(i==0) {
                return false;
            }
            else {
                return true;
            }
        }
        catch(Exception exception) {
            new Error("No Rooms Available.\n\nERROR:  "+exception).showErrorDialog();
            return false;
        }
    }
    
    private boolean hasRates() {
        String query = "SELECT RateID FROM Rates;";
        int i=0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                i++;
            }
            
            if(i==0) {
                return false;
            }
            else {
                return true;
            }
        }
        catch(Exception exception) {
            new Error("Initialize Rates First.\n\nERROR:  "+exception).showErrorDialog();
            return false;
        }
    }
    
    private boolean hasBoarders() {
        String query = "SELECT MAX(BoarderID) FROM Boarders;";
        int i=0;
        
        try {
            setConnection(Database.getConnection());
            setPst(getConnection().prepareStatement(query));
            setRs(getPst().executeQuery());
            
            while(getRs().next()) {
                i = getRs().getInt(1);
            }
            
            if(i==0) {
                return false;
            }
            else {
                return true;
            }
        }
        catch(Exception exception) {
            new Error("No Boarders Added.\n\nERROR:  "+exception).showErrorDialog();
            return false;
        }
    }

    public String getInfoString() {
        return infoString;
    }

    public void setInfoString(String infoString) {
        this.infoString = infoString;
        info.setText(infoString);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addBoarderButton = new javax.swing.JButton();
        viewBoarderButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        logo = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Saligumba Boarding House");

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management System");

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Poblacion, Trinidad, Bohol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jLabel3))
        );

        addBoarderButton.setText("Add Boarder");
        addBoarderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBoarderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBoarderButtonMouseExited(evt);
            }
        });
        addBoarderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBoarderButtonActionPerformed(evt);
            }
        });

        viewBoarderButton.setText("View Boarder");
        viewBoarderButton.setEnabled(false);
        viewBoarderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewBoarderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewBoarderButtonMouseExited(evt);
            }
        });
        viewBoarderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBoarderButtonActionPerformed(evt);
            }
        });

        paymentButton.setText("Payment");
        paymentButton.setEnabled(false);
        paymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentButtonMouseExited(evt);
            }
        });
        paymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBoarderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewBoarderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(paymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(addBoarderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewBoarderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info.", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Information");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setToolTipText("Click Here");
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoMouseReleased(evt);
            }
        });
        logo.setBounds(0, 0, 265, 169);
        jLayeredPane1.add(logo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBoarderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBoarderButtonActionPerformed
        if(hasRooms() == true) {
            if(hasRates() == true) {
            setContainer(frame_.getContentPane());
            container_.setLayout(new BorderLayout());
        
            BoarderPanel borderPanel = new BoarderPanel();
            borderPanel.setOpaque(true);
                
            container_.remove(0);
            container_.add(borderPanel);
            container_.validate();
            }
            else {
                
            }
        }
        else {
            
        }
    }//GEN-LAST:event_addBoarderButtonActionPerformed

    private void viewBoarderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBoarderButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        ViewBoarderPanel borderPanel = new ViewBoarderPanel();
        borderPanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(borderPanel);
        container_.validate();
    }//GEN-LAST:event_viewBoarderButtonActionPerformed

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        PaymentPanel paymentPanel = new PaymentPanel();
        paymentPanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(paymentPanel);
        container_.validate();
    }//GEN-LAST:event_paymentButtonActionPerformed

    private void addBoarderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBoarderButtonMouseEntered
        setInfoString("Select to add new record of Boarder.");
    }//GEN-LAST:event_addBoarderButtonMouseEntered

    private void viewBoarderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewBoarderButtonMouseEntered
        setInfoString("Select to view record of Boarder.");
    }//GEN-LAST:event_viewBoarderButtonMouseEntered

    private void paymentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentButtonMouseEntered
        setInfoString("Select to add payment of Boarder.");
    }//GEN-LAST:event_paymentButtonMouseEntered

    private void addBoarderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBoarderButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_addBoarderButtonMouseExited

    private void viewBoarderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewBoarderButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_viewBoarderButtonMouseExited

    private void paymentButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_paymentButtonMouseExited

    private void logoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseEntered
        try
        {
            ImageIcon icon = new ImageIcon(new File("resources/logo_hover.png").toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            logo.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
        
        setInfoString("Saligumba Boarding House Management System");
    }//GEN-LAST:event_logoMouseEntered

    private void logoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseExited
        try
        {
            ImageIcon icon = new ImageIcon(new File("resources/logo.png").toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            logo.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
        
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_logoMouseExited

    private void logoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMousePressed
        try
        {
            ImageIcon icon = new ImageIcon(new File("resources/logo.png").toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            logo.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
        
        new AboutDialog(frame_).setVisible(true);
    }//GEN-LAST:event_logoMousePressed

    private void logoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseReleased
        try
        {
            ImageIcon icon = new ImageIcon(new File("resources/logo_hover.png").toURI().toURL());
            Image image2 = icon.getImage().getScaledInstance(160, 160, 0);
            ImageIcon icon2 = new ImageIcon(image2);
            logo.setIcon(icon2);
        }
        catch(Exception e)
        {
            new Error("The image was failed to initialize! ").showErrorDialog();
        }
    }//GEN-LAST:event_logoMouseReleased

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBoarderButton;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JButton paymentButton;
    private javax.swing.JButton viewBoarderButton;
    // End of variables declaration//GEN-END:variables
    private String infoString;
    private static JFrame frame_;
    private static Container container_;
    
    private static Connection connection_;
    private static PreparedStatement pst_;
    private static ResultSet rs_;
}