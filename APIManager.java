/*
 * To ch//ange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.Reader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 * Clase que hace la petición web, obtiene los datos en formato JSON y luego se
 * los pasa al objeto de la clase App
 *
 * @author Anabel Jorge
 */
public class APIManager implements Runnable {

    Scanner sc = new Scanner(System.in);

    private static String ciudadJSON;
    public static String ciudad;
    static String c, p;
    static String zmw;
    static String city;
    static String pais;
    static String provincia;
    static String condicion;
    static String temperatura;
    static String humedad;
    static String dirViento;
    static String presion;
    static String country;
    //private String url = "http://api.wunderground.com/api/557fbbd86ccb7622/conditions/q/Vinaros.json";
    private static String url = "";
    public static App clima = new App();
    ConfiguracionInicial config;
    

    /**
     * Método que recoge la ciudad por defecto del usuario para hacer la petición
     */
    public void setCity() {

        //ciudad = config.getCityUser();
    }


    public static void RecuperaDatos(){
    try {

        //Hago petición web a la API con la ciudad que me ha proporcionado el usuario
        url = "http://api.wunderground.com/api/557fbbd86ccb7622/conditions/q/Spain/" + ciudad + ".json";
        System.out.println(url);
        ciudadJSON = ClienteREST.request(url);

        //Le pasamos el String que contiene el JSON
        JSONObject obj = new JSONObject(ciudadJSON);

        if (obj.has("current_observation")) {

            System.out.println("Es un object");

            //Accedemos a current_observation, que es un objeto JSON
            JSONObject cObs = obj.getJSONObject("current_observation");

            //Accedemos a display_location, que es un objeto JSON
            JSONObject dLoc = cObs.getJSONObject("display_location");
            city = dLoc.getString("city");
            clima.getCiudad(city);
            pais = dLoc.getString("state_name");
            clima.getPais(pais);

            //Accedemos a observation_location, que es un objeto JSON
            JSONObject oLoc = cObs.getJSONObject("observation_location");
            provincia = oLoc.getString("state");
            clima.getProvincia(provincia);

            //Accedemos a current_observation, sacamos información y se la mandamos a los diferenters métodos de la clase Weather
            condicion = cObs.getString("weather");
            clima.getClima(condicion);
            temperatura = cObs.getString("temperature_string");
            clima.getTemperatura(temperatura);
            humedad = cObs.getString("relative_humidity");
            clima.getHumedad(humedad);
            dirViento = cObs.getString("wind_dir");
            clima.getDirViento(dirViento);
            presion = cObs.getString("pressure_in");
            clima.getPresion(presion);
        } 
        else {
            if (ciudad.equals("Valencia")) {

                url = "http://api.wunderground.com/api/557fbbd86ccb7622/conditions/q/zmw:00000.68.08285.json";
                ciudadJSON = ClienteREST.request(url);

                //Le pasamos el String que contiene el JSON
                JSONObject objV = new JSONObject(ciudadJSON);
                //Accedemos a current_observation, que es un objeto JSON
                JSONObject cObs = objV.getJSONObject("current_observation");

                //Accedemos a display_location, que es un objeto JSON
                JSONObject dLoc = cObs.getJSONObject("display_location");
                city = dLoc.getString("city");
                clima.getCiudad(city);
                pais = dLoc.getString("state_name");
                clima.getPais(pais);

                //Accedemos a observation_location, que es un objeto JSON
                JSONObject oLoc = cObs.getJSONObject("observation_location");
                provincia = oLoc.getString("state");
                clima.getProvincia(provincia);

                //Accedemos a current_observation, sacamos información y se la mandamos a los diferenters métodos de la clase Weather
                condicion = cObs.getString("weather");
                clima.getClima(condicion);
                temperatura = cObs.getString("temperature_string");
                clima.getTemperatura(temperatura);
                humedad = cObs.getString("relative_humidity");
                clima.getHumedad(humedad);
                dirViento = cObs.getString("wind_dir");
                clima.getDirViento(dirViento);
                presion = cObs.getString("pressure_in");
                clima.getPresion(presion);

            } 
            else {
                System.out.println("Es un array");

                JSONObject response = obj.getJSONObject("response");

                //Accedemos a results, que es un array JSON
                JSONArray results = response.getJSONArray("results");

                System.out.println("Hola!");
                //Recorro el array con un bucle for y saco el valor de zmw
                for (int i = 0; i < results.length(); i++) {

                    JSONObject city = results.getJSONObject(i);

                    zmw = city.getString("zmw");
                    country = city.getString("country_name");
                    System.out.println(country);
                }

                url = "http://api.wunderground.com/api/557fbbd86ccb7622/conditions/q/zmw:" + zmw + ".json";
                ciudadJSON = ClienteREST.request(url);

                JSONObject cObs = obj.getJSONObject("current_observation");

                //Accedemos a display_location, que es un objeto JSON
                JSONObject dLoc = cObs.getJSONObject("display_location");
                city = dLoc.getString("city");
                clima.getCiudad(city);
                pais = dLoc.getString("state_name");
                clima.getPais(pais);

                //Accedemos a observation_location, que es un objeto JSON
                JSONObject oLoc = cObs.getJSONObject("observation_location");
                provincia = oLoc.getString("state");
                clima.getProvincia(provincia);

                //Accedemos a current_observation, sacamos información y se la mandamos a los diferenters métodos de la clase Weather
                condicion = cObs.getString("weather");
                clima.getClima(condicion);
                temperatura = cObs.getString("temperature_string");
                clima.getTemperatura(temperatura);
                humedad = cObs.getString("relative_humidity");
                clima.getHumedad(humedad);
                dirViento = cObs.getString("wind_dir");
                clima.getDirViento(dirViento);
                presion = cObs.getString("pressure_in");
                clima.getPresion(presion);
            }

        }

        //clima.insertImgClima();
        System.out.println("Ciudad: " + city);
        System.out.println("Pais: " + pais);
        System.out.println("Provincia: " + provincia);
        System.out.println("Clima: " + condicion);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Humedad: " + humedad);
        System.out.println("Direccion del viento: " + dirViento);
        System.out.println("Presion: " + presion);
        System.out.println(clima.getCiudad(ciudad));
        clima.getProvincia(provincia);
    } catch (JSONException ex) {
        Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);

    }

    }
    
    /**
     * Método que pide la información en la petición web y recoge todos los parámetros pedidos. 
     * Contiene un Timer para que haga la petición automáticamente cada X tiempo estipulado
     */
    public void run() {
        while (Boolean.TRUE) {

            //setCity();
            //Pido ciudad al usuario
            //System.out.println("Ciudad:");
            ciudad = sc.nextLine();

            
            //Creo un Timer para actualizar la información del clima cada X tiempo
            //Clase en la que está el código a ejecutar 
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    RecuperaDatos();
                }
            };

            //Aquí se pone en marcha el timer 
            Timer timer = new Timer();

            //Dentro de 0 milisegundos avísame cada X milisegundos 
            timer.scheduleAtFixedRate(timerTask, 0, 10000);
        }

    }
}
