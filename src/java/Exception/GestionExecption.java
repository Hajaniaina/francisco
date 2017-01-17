/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;
 import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class GestionExecption extends Exception  {
   

/**
 *
 * @author User
 */
    public GestionExecption() {
		
	}  
	  
	public GestionExecption(String message) {  
		super(message);
		JOptionPane.showMessageDialog(null,message);
	}  
	 
	public GestionExecption(Throwable cause) {  
		super(cause); 
	}  
	 
	public GestionExecption(String message, Throwable cause) {  
		super(message, cause); 
	}

}

