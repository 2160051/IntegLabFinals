/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boardinghousemanagement;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public final class Error extends JDialog {
    
    public Error(String error) {
        setError_(error);
    }
    
    public void showErrorDialog() {
        
        JOptionPane.showMessageDialog(this, getError_(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }

    public String getError_() {
        return error_;
    }

    public void setError_(String error_) {
        this.error_ = error_;
    }
    
    private String error_;
    
}
