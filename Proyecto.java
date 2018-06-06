/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.UIManager;

public class Proyecto {

    public static Thread am;
    //public static Thread wp;
    
     /**
     * Funcion Main del programa
     * @param args the command line arguments
     * @author Anabel Jorge
     */
    public static void main(String[] args) {
 
        //Llamo a la ventana de Login
        Login l = new Login();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    
                } catch (Exception e) {
                    
                }
            }
        }); 
        
        //Creo un hilo de la clase APIManager
        am = new Thread(new APIManager());
        //Lo inicio
        //am.start();
        
        //wp = new Thread(new WindowApp());
        //wp.start();
   
       
        // TODO code application logic here
    }
}
