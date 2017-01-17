/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Confirmation {
    public int verificationFait(String message)
    {
       
       JOptionPane jop = new JOptionPane();            
       int option = jop.showConfirmDialog(null, message, "Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       return option;
    }
}
