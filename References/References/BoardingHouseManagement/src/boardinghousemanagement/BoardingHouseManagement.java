/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author user
 */
public class BoardingHouseManagement {

    JFrame frame = new JFrame("Boarding House Management System");
    
    public BoardingHouseManagement() {
        try {
            frame.setIconImage(ImageIO.read(new File("resources/logo.png").getAbsoluteFile()));
        } catch (Exception ex) {
            new Error("Cannot load logo icon. \n\nERROR: "+ex).showErrorDialog();
        }
    }
    public void initialize () {
        Database database = new Database();
        database.connect();
        
        setFrame (frame);
        frame_.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_.setResizable(false);
        
        container_ = frame_.getContentPane();
        container_.setLayout(new BorderLayout());
        
        /*UserPanel boarderPanel = new UserPanel();
        container_.add(boarderPanel);
        container_.validate();*/
        
        frame_.setSize (760, 700);
        frame_.setLocationRelativeTo(null);
        
        if(database.isConnected()) {
            show();
                
            LoginDialog login = new LoginDialog(frame_);
            login.setVisible(true);
        }
        else {
            System.exit(0);
        }
    }
    
    public void show(){
        frame_.setVisible(true);
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

    public static void setContainer(Component component) {
        container_.add(component);
        container_.validate();
    }

    
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater (new Runnable() {

            @Override
            public void run() {
                new BoardingHouseManagement().initialize();
            }
            
        });
        
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            Error error = new Error("Cannot Initialized!\n\nERROR:    "+e);
            error.showErrorDialog();
        }
    }
    
    private static JFrame frame_;
    private static Container container_;
}
