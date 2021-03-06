/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    
    int x, y;
    public static WindowApp wp;
    public static String userName;
    public static String passwordUser;
    
    public Login() {
        initComponents();
        this.setVisible(true);
        
        //Hacemos los JTextField trasnparentes
        user.setBackground(new Color(0,0,0,64));
        pass.setBackground(new Color(0,0,0,64));
        
        //Cambiar icono de la aplicación por el logo que he creado
        setIconImage(new ImageIcon(getClass().getResource("../logo/Logo.png")).getImage());
        
        //Indicamos que la ventana se abra en el medio
        this.setLocationRelativeTo(null);
        
        //Hacemos el fondo transparente
        AWTUtilities.setWindowOpaque(this, false);
        
        //Más abajo quitamos la ventana con el método "setUndecorated(true);"
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
        inicioSesion = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        password = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        register = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passForgot = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        circulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicioSesion.setFont(new java.awt.Font("Courier New", 1, 52)); // NOI18N
        inicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        inicioSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioSesion.setText("Inicio de sesión");
        inicioSesion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                inicioSesionMouseDragged(evt);
            }
        });
        inicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inicioSesionMousePressed(evt);
            }
        });
        jPanel1.add(inicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        usuario.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("Usuario:");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        user.setBackground(new java.awt.Color(0, 0, 0));
        user.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setBorder(null);
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 267, 320, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 320, 40));

        password.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Contraseña:");
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        pass.setBackground(new java.awt.Color(0, 0, 0));
        pass.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(null);
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 347, 320, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 320, 40));

        register.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("Registrarse");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 420, -1));

        login.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("Iniciar sesión");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 490, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/linea.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, 30));

        passForgot.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        passForgot.setForeground(new java.awt.Color(255, 255, 255));
        passForgot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passForgot.setText("He olvidado la contraseña");
        passForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passForgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passForgotMouseExited(evt);
            }
        });
        jPanel1.add(passForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, 530, -1));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/cerrar_44.png"))); // NOI18N
        cerrar.setToolTipText("Cerrar aplicación");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 50, -1));

        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/minimizar_BL.png"))); // NOI18N
        minimizar.setToolTipText("Minimizar aplicación");
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 70, 30));

        circulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/800px-POMEGRANATE_Logo2.png"))); // NOI18N
        circulo.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        circulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                circuloMouseDragged(evt);
            }
        });
        circulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                circuloMousePressed(evt);
            }
        });
        jPanel1.add(circulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 802, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Para poder mover la ventana
    private void inicioSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioSesionMousePressed
       
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioSesionMousePressed

    //Para poder mover la ventana
    private void inicioSesionMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioSesionMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioSesionMouseDragged

    //Para poder mover la ventana
    private void circuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuloMousePressed
        
        x = evt.getX();
        y = evt.getY();
         // TODO add your handling code here:
    }//GEN-LAST:event_circuloMousePressed

    //Para poder mover la ventana
    private void circuloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuloMouseDragged
        
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_circuloMouseDragged

    //Creamos un objeto de tipo Registro para llamar a la ventana de registro y que se abra  
    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked

        Registro r = new Registro();
        r.setVisible(true);
        
        //Cerramos la ventana actual
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_registerMouseClicked

    //Cerrar aplicación
    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
       
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseClicked

    //Minimizar aplicación
    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked

        this.setExtendedState(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizarMouseClicked

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered

        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=login.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        login.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 44));
        
        //Cambio la posición del jlabel
        jPanel1.setLayout(null);
        login.setLocation(150, 450);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        
        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=login.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        login.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 36));

        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseExited

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
       
        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=register.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        register.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 44));
        
        //Cambio la posición del jlabel
        jPanel1.setLayout(null);
        register.setLocation(190, 530);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        
        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=register.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        register.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 36));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_registerMouseExited

    private void passForgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passForgotMouseEntered
        
        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=passForgot.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        passForgot.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));
        
        //Cambio la posición del jlabel
        jPanel1.setLayout(null);
        passForgot.setLocation(130, 660);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_passForgotMouseEntered

    private void passForgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passForgotMouseExited

        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=passForgot.getFont(); 

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        passForgot.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_passForgotMouseExited

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked

        try {
            connect();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbQuerys conection = new dbQuerys();
            
            if (conection.Login()) {
                
                wp = new WindowApp();
                wp.setVisible(true);
                dispose();
            } 
            else {
                
                JOptionPane.showMessageDialog(null, "Error: Usuario incorrecto", "Usuario incorrecto", JOptionPane.WARNING_MESSAGE);
            }
            
            
            //wp = new WindowApp();
            //dispose();
            /*Proyecto.wp = new Thread(new WindowApp());
            Proyecto.wp.start();*/
            //wp.setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginMouseClicked

    /**
     * Metodo 
     * @throws SQLException 
     */
    public void connect() throws SQLException {
        
        dbQuerys conection = new dbQuerys();
        
        getPassUser();
        getUserName();
        
        conection.Login();
    }
    
    /**
     * Metodo que guarda en una variable el nombre del usuario y lo devuelve a la clase de la base de datos
     * @return userName Nombre de usuario 
     */
    public String getUserName() {
        
        userName = user.getText();
        return userName;
    }
    
    /**
     * Metodo que guarda en una variable el la contraseña del usuario y lo devuelve a la clase de la base de datos
     * @return passwordUser Contraseña de usuario
     */
    public String getPassUser() {
        
        passwordUser = pass.getText().toString();
        return passwordUser;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel circulo;
    private javax.swing.JLabel inicioSesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel login;
    private javax.swing.JLabel minimizar;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel passForgot;
    private javax.swing.JLabel password;
    private javax.swing.JLabel register;
    private javax.swing.JTextField user;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
