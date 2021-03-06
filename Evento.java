
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.text.DefaultCaret;

/**
 * Clase que contiene la ventana grafica donde se escriben los eventos que luego se veran en la ventana principal
 * @author Anabel Jorge
 */
public class Evento extends javax.swing.JFrame {

    int x,y;
    String event;
    String[] eventos=new String[5];
    int numevento=0;
    
    /**
     * Creates new form Evento
     */
    public Evento() {
        initComponents();
        
        //Cambiar icono de la aplicación por el logo que he creado
        setIconImage(new ImageIcon(getClass().getResource("../logo/Logo.png")).getImage());

        //Indicamos que la ventana se abra en el medio
        this.setLocationRelativeTo(null);

        //Hacemos el fondo transparente
        AWTUtilities.setWindowOpaque(this, false);
        
        textArea();

        //Más abajo quitamos la ventana con el método "setUndecorated(true);"
    }
    
    /**
     * Método que define las propiedades del TextArea y el jScrollPane
     */
    public void textArea() {

        //Hago el jScrollPane trasnaparente y sin borde
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        //Hago que la scrollbar esté siempre arriba por defecto
        //DefaultCaret caret = (DefaultCaret) texto.getCaret();
        //caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        //Hago el TextArea transparente y le quito el borde
        texto.setBorder(null);
        texto.setBackground(new Color(0, 0, 0, 0));

        //Hago que el texto se ajuste al tamaño del TextArea y cambie de línea
        //texto.setLineWrap(true);
        //Cambia de línea sin cortar palabras
        //texto.setWrapStyleWord(true);
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
        minimizar = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JEditorPane();
        papel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/minimizar_BL.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 70, 60));

        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/cerrar_44.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 60, 60));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmar");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 300, 50));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        texto.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        texto.setOpaque(false);
        jScrollPane1.setViewportView(texto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 450, 400));

        papel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        papel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        papel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesGraficas/Event.png"))); // NOI18N
        papel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                papelMouseDragged(evt);
            }
        });
        papel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                papelMousePressed(evt);
            }
        });
        jPanel1.add(papel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 760));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked

        this.setExtendedState(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizarMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        
        //Login.wp.setVisible(true);
        ConfiguracionInicial.wpInicial.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseClicked

    private void papelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_papelMousePressed
    
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_papelMousePressed

    private void papelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_papelMouseDragged
    
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_papelMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        if(numevento<=eventos.length){
            eventos[numevento]=texto.getText();
            numevento++;
        }
        event = texto.getText();
        ConfiguracionInicial.wpInicial.setVisible(true);
        dispose();
        //ConfiguracionInicial.wpInicial.nuevoEvento(event);
        ConfiguracionInicial.wpInicial.newEvent(eventos);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel papel;
    private javax.swing.JEditorPane texto;
    // End of variables declaration//GEN-END:variables
}
