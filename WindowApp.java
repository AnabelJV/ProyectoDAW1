/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AppPackage.AnimationClass;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

/**
 * Clase que ejerce el papel de ventana principal, donde se muestran gráficamente todos los datos y el usuario puede operar con 
 * las diferentes funcionalidades de la aplicación (consultar clima; crear, modificar y borrar eventos; leer frases; insertar 
 * notas e imágenes en la agenda)
 * @author Anabel Jorge
 */
public class WindowApp extends javax.swing.JFrame {

    int x, y;
    App app = new App();
    String ciudad, provincia, pais, humedad, presion, condicion, dirviento;
    String frase;
    int aleatorio;
    int numero;
    int contador = 0;
    int anyo;
    int mes;
    int dia;
    String fecha;
    String newCity;
    //String eventos;
    public APIManager am;
    App clima;
    

    /**
     * Mátodo constructor de la clase, donde llamo a los diferentes métodos que han de iniciarse al ejecutar la clase
     * Creates new form App
     */
    public WindowApp() {
        initComponents();

        this.setVisible(true);

        //Cambiar icono de la aplicación por el logo que he creado
        setIconImage(new ImageIcon(getClass().getResource("../logo/Logo.png")).getImage());

        //Indicamos que la ventana se abra en el medio
        this.setLocationRelativeTo(null);

        //Hacemos el fondo transparente
        AWTUtilities.setWindowOpaque(this, false);

        //Más abajo quitamos la ventana con el método "setUndecorated(true);"
        //Llamo a los métodos que hay más abajo
        escalarImg();
        textArea();
        elegirFrase();
        //clima();
        Proyecto.am.start();
    }
    
    public void newEvent(String[] evts){
        
        for(int i=0;i<evts.length;i++){
            if(evts[i].length()!=0)
                e.setText(e.getText()+"\n"+dia + " " + mes + " " + evts[i]);
        }
    }
    public void nuevoEvento(String eventos) {
        
        e.setText(dia + " " + mes + " " + eventos);
        
    }

    /**
     * Método que se encargade recoger la ciudad introducida por el usuario en caso de que quiera ver el tiempo de 
     * otra ciudad que no sea la que le aperece por defecto. Comprueba que los carácteres son válidos, pudiendo solo 
     * contener letras y no ningún otro carácter
     */
    public void clima() {
        String ciudad="";

        int i;
        for (i=0; i<insertCity.getText().length(); i++) {
           
           newCity = insertCity.getText();
           
           if (newCity.charAt(i)==32 || (newCity.charAt(i) > 64 && newCity.charAt(i) < 91 || newCity.charAt(i) > 96 && newCity.charAt(i) < 123)) {
               
               System.out.println("Es correcto");
               if(newCity.charAt(i)==32)
                   ciudad = ciudad + "%20";
               else
                   ciudad = ciudad + newCity.charAt(i);
           }
           else {

               System.out.println("Es incorrecto");
               break;
           }
        }
       
        if (i==newCity.length()) {
            //APIManager.ciudad=newCity;
            APIManager.ciudad=ciudad;
            cambiarCiudad();
            APIManager.RecuperaDatos();
        }
        else {
            
            JOptionPane.showMessageDialog(null, "Introduzca solo letras", "Craácter no válido", JOptionPane.WARNING_MESSAGE);
            System.out.println("Escriba solo letras");
        }
    }
    
    /**
     * Metodo que cambia la ciudad por defecto del clima y le da el valor de la nueva ciudad introducida por el usuario
     */
    public void cambiarCiudad() {
        
        am.ciudad = newCity;
    }

    /**
     * Método que crea un número aleatorio para elegir una frase y que recoge las frases de la clase App que es la que las contiene.
     * Además, se encarga del avance y retroceso entre frases, así como de que al llegar al final vuelva a empezar y viceversa. Luego
     * llama al método frase() para mostrarla
     */
    public void elegirFrase() {

        //Coge una frase aleatoria cada vez que inicias el programa
        if (contador == 0) {

            aleatorio = (int) (Math.random() * 50) + 1;
            numero = aleatorio;
        } //Visualiza las frases siguientes
        else if (contador == 1) {

            numero = numero + 1;
        } //Visualiza las frases anteriores
        else if (contador == 2) {

            numero = numero - 1;
        }

        //Cuando llega a la última frase, vuelve a empezar
        if (numero > 50) {

            numero = 1;
        }

        //Cuando llega a la primera frase, vuelve al final
        if (numero < 1) {

            numero = 50;
        }

        //Llamo al método de la clase App donde me pasa una frase
        frase = app.newPhrase(numero);

        //Llamo al método que inserta la frase en el TextArea
        frase();
    }

    /**
     * Método que se encarga de introducir la frase elegida en el método elegirFrase() dentro de un componente jTextArea
     */
    public void frase() {

        //Inserto la frase en el TextArea
        phrase.setText(frase);
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
        DefaultCaret caret = (DefaultCaret) phrase.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        //Hago el TextArea transparente y le quito el borde
        phrase.setBorder(null);
        phrase.setBackground(new Color(0, 0, 0, 0));

        //Hago que el texto se ajuste al tamaño del TextArea y cambie de línea
        phrase.setLineWrap(true);
        //Cambia de línea sin cortar palabras
        phrase.setWrapStyleWord(true);
        //La frase no es editable por el usuario, es decir, no se puede escribir en el TextArea
        phrase.setEditable(false);
        
        //Hago el jScrollPane trasnaparente y sin borde
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(null);

        //Hago que la scrollbar esté siempre arriba por defecto
        //DefaultCaret care = (DefaultCaret) e.getCaret();
        //care.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        //Hago el TextArea transparente y le quito el borde
        e.setBorder(null);
        e.setBackground(new Color(0, 0, 0, 0));

        //Hago que el texto se ajuste al tamaño del TextArea y cambie de línea
        e.setLineWrap(true);
        //Cambia de línea sin cortar palabras
        e.setWrapStyleWord(true);
        
        //La frase no es editable por el usuario, es decir, no se puede escribir en el TextArea
        //e.setEditable(false);
    }

    /**
     * Método que se encarga de escalar imágenes para que se ajusten al tamaño del label
     */
    public void escalarImg() {

        //Redimensiono la imagen de la flecha para que se ajuste al tamaño del JLabel
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("../imagenes/flechaDe.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(fDer.getWidth(), fDer.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        fDer.setIcon(iconoEscalado);

        //Redimensiono la imagen de la flecha para que se ajuste al tamaño del JLabel
        ImageIcon imgIconI = new ImageIcon(getClass().getResource("../imagenes/flechaIz.png"));
        Image imgEscaladaI = imgIconI.getImage().getScaledInstance(fIzq.getWidth(), fIzq.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoI = new ImageIcon(imgEscaladaI);
        fIzq.setIcon(iconoEscaladoI);

        //Redimensiono la imagen del icono de fotos para que se ajuste al tamaño del JLabel
        ImageIcon imgIconF = new ImageIcon(getClass().getResource("../imagenes/Photos.png"));
        Image imgEscaladaF = imgIconF.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoF = new ImageIcon(imgEscaladaF);
        photo.setIcon(iconoEscaladoF);

        //Redimensiono la imagen del icono de notas para que se ajuste al tamaño del JLabel
        ImageIcon imgIconP = new ImageIcon(getClass().getResource("../imagenes/postits.png"));
        Image imgEscaladaP = imgIconP.getImage().getScaledInstance(notes.getWidth(), notes.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoP = new ImageIcon(imgEscaladaP);
        notes.setIcon(iconoEscaladoP);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        phrase = new javax.swing.JTextArea();
        fDer = new javax.swing.JLabel();
        fIzq = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        e = new javax.swing.JTextArea();
        labelPhrase = new javax.swing.JLabel();
        nombreCiudad = new javax.swing.JLabel();
        nombreProvincia = new javax.swing.JLabel();
        nombrePais = new javax.swing.JLabel();
        nombreCondicion = new javax.swing.JLabel();
        numTemperatura = new javax.swing.JLabel();
        numHumedad = new javax.swing.JLabel();
        nombreDirViento = new javax.swing.JLabel();
        numPresion = new javax.swing.JLabel();
        tiempoImg = new javax.swing.JLabel();
        insertCity = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        labelWeather = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        notes = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noDate = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        datechooser = new com.toedter.calendar.JDateChooser();
        calendar = new com.toedter.calendar.JCalendar();
        labelCalendar = new javax.swing.JLabel();
        menuIcon = new javax.swing.JLabel();
        userEdit = new javax.swing.JLabel();
        info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        phrase.setEditable(false);
        phrase.setColumns(20);
        phrase.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        phrase.setForeground(new java.awt.Color(255, 255, 255));
        phrase.setLineWrap(true);
        phrase.setRows(7);
        phrase.setBorder(null);
        phrase.setOpaque(false);
        jScrollPane1.setViewportView(phrase);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, 220, 200));

        fDer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fDerMouseClicked(evt);
            }
        });
        jPanel1.add(fDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 820, 40, 40));

        fIzq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fIzqMouseClicked(evt);
            }
        });
        jPanel1.add(fIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 820, 40, 40));

        jScrollPane2.setOpaque(false);

        e.setColumns(20);
        e.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        e.setRows(8);
        e.setOpaque(false);
        jScrollPane2.setViewportView(e);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 370, 430));

        labelPhrase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesGraficas/Mancha.png"))); // NOI18N
        labelPhrase.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelPhraseMouseDragged(evt);
            }
        });
        labelPhrase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelPhraseMousePressed(evt);
            }
        });
        jPanel1.add(labelPhrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 580, 580));

        nombreCiudad.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        nombreCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombreCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 300, 50));

        nombreProvincia.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        nombreProvincia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombreProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 240, 40));

        nombrePais.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        nombrePais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombrePais, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 210, 40));

        nombreCondicion.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        nombreCondicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombreCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 440, 50));

        numTemperatura.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        numTemperatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(numTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 240, 50));

        numHumedad.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        numHumedad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(numHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 180, 50));

        nombreDirViento.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        nombreDirViento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombreDirViento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 160, 50));

        numPresion.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        numPresion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(numPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 190, 50));
        jPanel1.add(tiempoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 110, 90));

        insertCity.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        insertCity.setToolTipText("");
        insertCity.setBorder(null);
        insertCity.setOpaque(false);
        jPanel1.add(insertCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 250, 20));

        jButton1.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 130, 30));

        labelWeather.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesGraficas/nube.png"))); // NOI18N
        labelWeather.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelWeatherMouseDragged(evt);
            }
        });
        labelWeather.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelWeatherMousePressed(evt);
            }
        });
        jPanel1.add(labelWeather, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 600, -1));

        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/cerrar_44.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 0, 60, 60));

        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/800px/minimizar_BL.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 0, 80, 70));

        notes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notesMouseClicked(evt);
            }
        });
        jPanel1.add(notes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 730, 70, 60));

        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });
        jPanel1.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 730, 70, 60));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 580, 370, 260));

        usuario.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        usuario.setText("Usuario:");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 140, 100, 30));

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 140, 260, 30));

        noDate.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        noDate.setForeground(new java.awt.Color(255, 0, 0));
        noDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(noDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 290, 420, 30));

        confirmar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.setToolTipText("Confirmar fecha");
        confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarMouseClicked(evt);
            }
        });
        jPanel1.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 630, 170, 30));

        datechooser.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 340, 230, 30));

        calendar.setEnabled(false);
        calendar.setTodayButtonText("");
        calendar.setTodayButtonVisible(true);
        calendar.setWeekOfYearVisible(false);
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 370, 330, 240));

        labelCalendar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesGraficas/AgendaM.png"))); // NOI18N
        labelCalendar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelCalendarMouseDragged(evt);
            }
        });
        labelCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelCalendarMousePressed(evt);
            }
        });
        jPanel1.add(labelCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 1120, 910));

        menuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesGraficas/MenuPeq.png"))); // NOI18N
        menuIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconMouseClicked(evt);
            }
        });
        jPanel1.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 70));

        userEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/UserEdit.png"))); // NOI18N
        jPanel1.add(userEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 70, 50, 60));

        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Informacion.png"))); // NOI18N
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
        });
        jPanel1.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 140, 40, 60));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Minimizar aplicación
    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked

        this.setExtendedState(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizarMouseClicked

    //Cerrar aplicación
    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked

        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseClicked

    //Para poder mover la ventana
    private void labelCalendarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCalendarMousePressed

        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_labelCalendarMousePressed

    //Para poder mover la ventana
    private void labelCalendarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCalendarMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_labelCalendarMouseDragged

    //Para poder mover la ventana
    private void labelWeatherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelWeatherMousePressed

        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_labelWeatherMousePressed

    //Para poder mover la ventana
    private void labelWeatherMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelWeatherMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_labelWeatherMouseDragged

    //Para poder mover la ventana
    private void labelPhraseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPhraseMousePressed

        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_labelPhraseMousePressed

    //Para poder mover la ventana
    private void labelPhraseMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPhraseMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_labelPhraseMouseDragged

    //Hago aparecer y desaparecer el menú cada vez que se hace click
    private void menuIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIconMouseClicked

        //Mover jLabel de usuario hacia la derecha al pulsar sobre el icono del menú
        AnimationClass user = new AnimationClass();
        user.jLabelXRight(-50, 0, 10, 10, userEdit);
        //Mover jLabel de info hacia la derecha al pulsar sobre el icono del menú
        AnimationClass inf = new AnimationClass();
        inf.jLabelXRight(-40, 0, 10, 10, info);
        //Mover jLabel de usuario hacia la izquierda al pulsar sobre el icono del menú
        AnimationClass userr = new AnimationClass();
        userr.jLabelXLeft(0, -50, 10, 10, userEdit);
        //Mover jLabel de info hacia la izquierda al pulsar sobre el icono del menú
        AnimationClass inff = new AnimationClass();
        inff.jLabelXLeft(0, -40, 10, 10, info);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_menuIconMouseClicked

    //Frase siguiente a la actual
    private void fDerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fDerMouseClicked

        contador = 1;
        elegirFrase();
        // TODO add your handling code here:
    }//GEN-LAST:event_fDerMouseClicked

    //Frase anterior a la actual
    private void fIzqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fIzqMouseClicked

        contador = 2;
        elegirFrase();
        // TODO add your handling code here:
    }//GEN-LAST:event_fIzqMouseClicked

    //Llamo a la ventana de información y oculto la principal
    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        
        //Creo objeto de la clase Información
        Informacion info = new Informacion();
        //Hago visible la ventana de información
        info.setVisible(true);
        //Hago invisible esta ventana
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_infoMouseClicked

    //Añade imagen a la agenda
    private void photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoMouseClicked

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Buscar imagen");

        //Ajusto la imagen al tamaño del label
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1, fc.getSelectedFile().toString());
            jLabel1.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_photoMouseClicked

    //Confirmar fecha seleccionada
    private void confirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseClicked

        //Si no esta vacío
        if (datechooser.getDate() != null) {
            
            //Capturo la fecha seleccionada y las guardo en variables separadas
            anyo = datechooser.getCalendar().get(Calendar.YEAR);
            mes = datechooser.getCalendar().get(Calendar.MONTH) + 1;
            dia = datechooser.getCalendar().get(Calendar.DAY_OF_MONTH);
            System.out.println(dia);
            System.out.println(mes);
            System.out.println(anyo);
            
            String diaa = String.valueOf(dia);
            String mess = String.valueOf(mes);
            String anyoo = String.valueOf(anyo);
            fecha = diaa + " " + mess + " " + anyo;
            
            //Llamo a la ventana de nuevo evento y oculto la principal
            Evento event = new Evento();
            event.setVisible(true);
            //dispose();
            this.setVisible(false);
        } //Si está vacío, salta mensaje de error
        else {
            
            noDate.setText("Debes seleccionar una fecha");
        }
        
        //nuevoEvento();
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarMouseClicked

    //Añade post-it con una nota
    private void notesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesMouseClicked

        
        // TODO add your handling code here:
    }//GEN-LAST:event_notesMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        clima();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JLabel cerrar;
    private javax.swing.JButton confirmar;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JTextArea e;
    private javax.swing.JLabel fDer;
    private javax.swing.JLabel fIzq;
    private javax.swing.JLabel info;
    private javax.swing.JTextField insertCity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel labelCalendar;
    private javax.swing.JLabel labelPhrase;
    private javax.swing.JLabel labelWeather;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel noDate;
    public static javax.swing.JLabel nombreCiudad;
    public static javax.swing.JLabel nombreCondicion;
    public static javax.swing.JLabel nombreDirViento;
    public static javax.swing.JLabel nombrePais;
    public static javax.swing.JLabel nombreProvincia;
    private javax.swing.JLabel notes;
    public static javax.swing.JLabel numHumedad;
    public static javax.swing.JLabel numPresion;
    public static javax.swing.JLabel numTemperatura;
    private javax.swing.JLabel photo;
    private javax.swing.JTextArea phrase;
    public static javax.swing.JLabel tiempoImg;
    private javax.swing.JLabel userEdit;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

}
