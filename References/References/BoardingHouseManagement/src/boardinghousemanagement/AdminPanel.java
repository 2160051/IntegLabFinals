/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import static boardinghousemanagement.MainPanel.getFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author user
 */
public final class AdminPanel extends javax.swing.JPanel {

    
    String INFO_STRING = "Select Action You Want!";
    
    public AdminPanel() {
        super(new BorderLayout());
        
        setFrame(BoardingHouseManagement.getFrame());
        setContainer(BoardingHouseManagement.getContainer());
        getFrame().setTitle("Administration - Saligumba Boarding House Management");
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
        roomsButton = new javax.swing.JButton();
        ratesButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
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
        jLabel4.setToolTipText("");

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

        roomsButton.setText("Rooms");
        roomsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roomsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                roomsButtonMouseExited(evt);
            }
        });
        roomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsButtonActionPerformed(evt);
            }
        });

        ratesButton.setText("Rates");
        ratesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratesButtonMouseExited(evt);
            }
        });
        ratesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratesButtonActionPerformed(evt);
            }
        });

        usersButton.setText("Users");
        usersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersButtonMouseExited(evt);
            }
        });
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ratesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(usersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ratesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(usersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        RoomsPanel roomsPanel = new RoomsPanel();
        roomsPanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(roomsPanel);
        container_.validate();
    }//GEN-LAST:event_roomsButtonActionPerformed

    private void ratesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratesButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        RatePanel ratePanel = new RatePanel();
        ratePanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(ratePanel);
        container_.validate();
    }//GEN-LAST:event_ratesButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        setContainer(frame_.getContentPane());
        container_.setLayout(new BorderLayout());
        
        UserPanel userPanel = new UserPanel();
        userPanel.setOpaque(true);
                
        container_.remove(0);
        container_.add(userPanel);
        container_.validate();
    }//GEN-LAST:event_usersButtonActionPerformed

    private void roomsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsButtonMouseEntered
        setInfoString("Select to manage rooms.");
    }//GEN-LAST:event_roomsButtonMouseEntered

    private void ratesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratesButtonMouseEntered
        setInfoString("Select to manage rates.");
    }//GEN-LAST:event_ratesButtonMouseEntered

    private void usersButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersButtonMouseEntered
        setInfoString("Select to manage payments.");
    }//GEN-LAST:event_usersButtonMouseEntered

    private void roomsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_roomsButtonMouseExited

    private void ratesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratesButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_ratesButtonMouseExited

    private void usersButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersButtonMouseExited
        setInfoString(INFO_STRING);
    }//GEN-LAST:event_usersButtonMouseExited

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JButton ratesButton;
    private javax.swing.JButton roomsButton;
    private javax.swing.JButton usersButton;
    // End of variables declaration//GEN-END:variables
    private String infoString;
    private static JFrame frame_;
    private static Container container_;
    
}
