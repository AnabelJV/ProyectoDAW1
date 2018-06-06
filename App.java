/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase que se encarga de procesar los datos que se mostrarán en la ventana gráfica principal
 * @author Anabel Jorge
 */
public class App implements Runnable {

    private String frase = "";
    private String ciudad;
    private String provincia;
    private String pais;
    private String clima;
    private String dirViento;
    private String temperatura;
    private String humedad;
    private String presion;
    
    public App() {

    }

    /**
     * Método que almacena una diversidad de frases para mostrar en la ventana gráfica principal. Recibe un número aleatorio 
     * del método elegirFrase() de la clase WindowApp y seguidamente elige el número de frase correspondiente al aleatorio 
     * recibido. Devuelve la frase en un String para mostrarla en otra clase
     * @param numero
     * @return 
     */
    public String newPhrase(int numero) {

        switch (numero) {

            case 1:
                frase = "Allí donde hay alguien a quien se quiere muchísimo y donde hay alguien que te quiere de veras… ese sí que es el lugar más bonito del mundo.";
                break;

            case 2:
                frase = "Es imposible, dijo el orgullo. Es arriesgado, dijo la experiencia. No tiene sentido, dijo la razón. Inténtalo, susurró el corazón.";
                break;

            case 3:
                frase = "Hay momentos en los que la vida te coloca a la misma distancia de huir o quedarte para siempre.";
                break;

            case 4:
                frase = "Es la vida un recipiente extraño lleno de gotas de distinto color. Una interacción con un universo complejo por el que deambulamos exponiendo "
                        + "el alma en cada canción. Un trapecio de emociones que se suceden una tras otra, en un intento constante de ser raíz, y flor en primavera."
                        + "Es la vida muchas cosas; pero sobre todo, la vida, son personas… que lo son. ";
                break;

            case 5:
                frase = "Y un día, sin tu esperarlo, me fui. Sin despedida, sin previo aviso, ni reproches. Porque a veces quedarse es ir demasiado lejos.";
                break;

            case 6:
                frase = "Que hermosa sensación, ésa de reír hasta que el estómago te duela, ése es un dolor que vale la pena.";
                break;

            case 7:
                frase = "Desde que te vi reír creo un poco más en la magia.";
                break;

            case 8:
                frase = "Que siempre colocaré la verdad frente a mis huellas, que no daré respuestas a quien no acepta mis preguntas, "
                        + "que no iré a aquel lugar en el que no me reconozca, que no daré la mano al que me señala con el dedo.";
                break;

            case 9:
                frase = "¿Sabes lo mejor de los corazones rotos? Que sólo pueden romperse de verdad una vez. Lo demás son rasguños.";
                break;

            case 10:
                frase = "Hay personas que aparecen en tu vida para que no desaparezcas. Justo a tiempo. Y los llamo suerte.";
                break;

            case 11:
                frase = "Y llegará el día en el que te des cuenta, que la única manera de envejecer más despacio, es viviendo más deprisa.";
                break;

            case 12:
                frase = "Solo te pido una cosa: Ojalá siempre sigas sintiéndote gigante cada vez que el mundo trate de convencerte de lo pequeño que eres.";
                break;

            case 13:
                frase = "Que cada día todo vaya más deprisa, sin pausa, sin miedo, sin querer, pero queriendo. Hacerse sonreír sin decir nada, seguramente "
                        + "eso lo sea todo, como la magia de cualquier comienzo.";
                break;

            case 14:
                frase = "Ser raro significa ser notablemente diferente, y eso, a diferencia de lo que muchos piensen, es algo maravilloso.";
                break;

            case 15:
                frase = "A veces no hace falta llegar a hablar para saber un millón de cosas de otra persona, que unos ojos son capaces de contar una historia.";
                break;

            case 16:
                frase = "Por norma general, cuanto más talento se tiene, más duda uno de tenerlo. Y a la inversa.";
                break;

            case 17:
                frase = "Y quizá tú estés ahí señalándome en la punta de alguna estrella. Y todas las palabras a las que llaman poesía solamente existan por ti.";
                break;

            case 18:
                frase = "Has de conformarte con lo único que puedo hacer: quererte -no el doble, ni por dos, ni al cuadrado, sino con la fuerza de un ejército "
                        + "de tres mil latidos y doscientos litros de sangre que queriéndote dar más de lo que tiene te da todo lo que es-.";
                break;

            case 19:
                frase = "En el momento en que te paras a pensar si quieres a alguien, ya has dejado de quererle para siempre.";
                break;

            case 20:
                frase = "Al final resultó que la única verdad es que todo fue mentira. Pero fuimos uno de esos errores con los que uno acierta en la vida.";
                break;

            case 21:
                frase = "Mi vida también fue una mancha negra en un lienzo blanco, -pero entonces alguien me llevó a un museo y me llamó arte-. "
                        + "Quizás solo se trate de encontrar quien te sigue mirando cuando tu cierras los ojos.";
                break;

            case 22:
                frase = "Quien siente mucho apego a un rebaño es que tiene algo de borrego.";
                break;

            case 23:
                frase = "Te quise tanto que cuando me rompiste el corazón te saqué de ahí para que no te hicieras daño.";
                break;

            case 24:
                frase = "Hay personas que son infinitas también cuando se acaban.";
                break;

            case 25:
                frase = "Y qué tal si te propongo un día cualquiera, cuando te vea indecisa, clavar tus ojos, lentamente, en mi vida; "
                        + "y con la mirada que con tus iris cada viernes improvisas, mueves la línea curva que lo endereza todo, tu sonrisa.";
                break;

            case 26:
                frase = "No sé definir muy bien lo que es extrañar, pero creo que debe ser la forma más bonita de abrazar a alguien "
                        + "desde lejos, mientras el alma se hace trizas.";
                break;

            case 27:
                frase = "Nunca tenemos una despedida guardada en la chaqueta para cuando decidamos abrigarnos, porque abrigarse también es irse.";
                break;

            case 28:
                frase = "Solo hay una razón lógica para que te sientas pequeño; con tus pasos has convertido este mundo en algo INMENSO.";
                break;

            case 29:
                frase = "Ojalá siempre nos demos cuenta de que los “gracias” son bonitos, los “te quiero” son para decir de verdad "
                        + "y los “perdón” otra forma de querer.";
                break;

            case 30:
                frase = "La última frase que le dices a una persona no significa nada, es el conjunto de todas las que forman el adiós no pronunciado,"
                        + " y espero que el mío no sea un reproche sino el “te quiero” más real que jamás se haya dicho en la tierra.";
                break;

            case 31:
                frase = "El cariño no se mide por las personas a las que atas, sino a las que eres capaz de deshacer los nudos.";
                break;

            case 32:
                frase = "Las palabras con que se envenena el corazón de un hijo, por mezquindad o por ignorancia, se quedan enquistadas "
                        + "en la memoria y tarde o temprano le queman el alma.";
                break;

            case 33:
                frase = "No quiero ponerle el nombre de “no puedo” a todo lo que no he intentado.  Que al final de nada sirve si vine, vi y vencí pero no luché.";
                break;

            case 34:
                frase = "Serás feliz, me dijo la vida. Pero primero te haré… fuerte.";
                break;

            case 35:
                frase = "Nos venden que rendirse es un fracaso, cuando en muchas ocasiones es el paso contundente que necesitamos para avanzar, "
                        + "el giro para salir del fango en el que nos ahogamos.";
                break;

            case 36:
                frase = "Uno acaba convirtiéndose en aquello que ve en los ojos de quienes desea.";
                break;

            case 37:
                frase = "Todo el mundo debería tener a alguien en su vida que le pegue un empujón de ánimo para ascender al menos dos escalones más de la "
                        + "propia consideración que tiene de sí mismo. Pocas personas lo saben, pero a veces solo hace falta que una persona crea que eres "
                        + "único para que tú también te veas así. ";
                break;

            case 38:
                frase = "Un buen mentiroso sabe que la mentira más efectiva es siempre una verdad a la que se le ha sustraído una pieza clave.";
                break;

            case 39:
                frase = "Que bonito es el invierno cuando no lo llevas dentro. Que bonito es el verano cada vez que sonríes.";
                break;

            case 40:
                frase = "Si hablamos de amistad, se trata de alguien que está cuando ni tú mismo sabes dónde te encuentras. Y que te abraza fuerte sin que se lo pidas.";
                break;

            case 41:
                frase = "¿Sabes de esas veces en las que solo deseas que la tierra te trague? Pues ahí, en esas, es donde tienes que comerte el mundo.";
                break;

            case 42:
                frase = "Si algún día la tristeza te hace una invitación, dile que ya tienes un compromiso con la alegría, y que le serás fiel toda la vida.";
                break;

            case 43:
                frase = "Dicen que si logras que alguien derrame una sola lágrima cuando te vas, tu estancia ha merecido la pena.";
                break;

            case 44:
                frase = "No nos damos cuenta de que son los pequeños instantes, los insignificantes, los que marcan el resto de nuestra existencia, "
                        + "lo que nos transforman en un “seremos” fruto de nuestros actos, nuestras vivencias, nuestras elecciones.";
                break;

            case 45:
                frase = "Recuerda: Puedes sentirte nube gris, pero siempre serás un pedacito de cielo para alguien.";
                break;

            case 46:
                frase = "Yo no quiero dejar huella en tu vida, quiero ser tu camino, quiero que te pierdas, que te salgas, "
                        + "que te rebeles, que vayas a contracorriente, que no me elijas, pero que siempre regreses a mí para encontrarte.";
                break;

            case 47:
                frase = "A ti podría decirte que para mí cualquier lugar es mi casa si eres tú quien abre la puerta.";
                break;

            case 48:
                frase = "La vida es demasiado corta como para malgastarla en cosas insustanciales. Perdonar no era un error, sino una muestra de sabiduría.";
                break;

            case 49:
                frase = "Una de las trampas de la infancia es que no hace falta comprender algo para sentirlo. Para cuando la razón es capaz de entender lo sucedido,"
                        + " las heridas en el corazón ya son demasiado profundas.";
                break;

            case 50:
                frase = "Yo no quiero que me necesites, quiero que cuentes conmigo hasta el infinito y que el más allá una tu casa y la mía. "
                        + "Yo no quiero que sueñes conmigo, quiero que me soples y me cumplas. Yo no quiero ser recuerdo, mi amor, quiero que me mires y adivines el futuro.";
                break;
        }

        return frase;
    }

    /**
     * Metodo que recibe el valor de la variable humedad obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param humedad
     * @return Valor de la variable humedad
     */
    public String getHumedad(String humedad) {
        this.humedad = humedad;
        WindowApp.numHumedad.setText(humedad);
        return humedad;
    }

    /**
     * Metodo que recibe el valor de la variable ciudad obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param ciudad
     * @return Valor de la variable ciudad
     */
    public String getCiudad(String ciudad) {
        this.ciudad = ciudad;
        //System.out.println("Mi ciudad es " + ciudad);
        WindowApp.nombreCiudad.setText(ciudad);
        return ciudad;
    }

    /**
     * Metodo que recibe el valor de la variable provincia obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param provincia
     * @return Valor de la variable provincia
     */
    public String getProvincia(String provincia) {
        this.provincia = provincia;
        //System.out.println("Mi provincia es " + provincia);
        WindowApp.nombreProvincia.setText(provincia);
        return provincia;
    }

    /**
     * Metodo que recibe el valor de la variable pais obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param pais
     * @return Valor de la variable pais
     */
    public String getPais(String pais) {
        this.pais = pais;
        WindowApp.nombrePais.setText(pais);
        return pais;
    }

    /**
     * Metodo que recibe el valor de la variable clima obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param clima
     * @return Valor de la variable clima
     */
    public String getClima(String clima) {
        this.clima = clima;
        WindowApp.nombreCondicion.setText(clima);
        return clima;
    }

    /**
     * Metodo que recibe el valor de la variable temperatura obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param temperatura
     * @return Valor de la variable temperatura
     */
    public String getTemperatura(String temperatura) {
        this.temperatura = temperatura;
        WindowApp.numTemperatura.setText(temperatura);
        return temperatura;
    }

    /**
     * Metodo que recibe el valor de la variable dirviento obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param dirViento
     * @return Valor de la variable dirViento
     */
    public String getDirViento(String dirViento) {
        this.dirViento = dirViento;
        WindowApp.nombreDirViento.setText(dirViento);
        return dirViento;
    }

    /**
     * Metodo que recibe el valor de la variable presion obtenida de la peticion web y lo inserta en el label de la ventana principal
     * @param presion
     * @return Valor de la variable presion
     */
    public String getPresion(String presion) {
        this.presion = presion;
        WindowApp.numPresion.setText(presion);
        return presion;
    }
    
    /**
     * 
     */
    public void insertImgClima() {
        
        Image imagen = null;
        try {
            //Inicializar y asignar url de la imagen a mostrar
            URL url = new URL("https://icons.wxug.com/i/c/i/" + clima + ".gif");
            //Asignacion de url a la imagen
            imagen = ImageIO.read(url);
               } catch (IOException e) {
                                      e.printStackTrace();
                                                                 }
        ImageIcon ic = new ImageIcon(imagen);
         //Mostrar imagen
         WindowApp.tiempoImg.setIcon(ic);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
