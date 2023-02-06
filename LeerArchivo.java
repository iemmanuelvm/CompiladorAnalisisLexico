/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class LeerArchivo 
{
//CLASE QUE LEE EL ARCHIVO POR LINEAS Y PASA LOS CARACTERES LEIDOS A UN ARRAYLIST
public ArrayList<String> leerLineas=new ArrayList<String>();
public ArrayList<String> muestraContenido(String prog1) throws FileNotFoundException, IOException 
    {
        String cadena;
        FileReader archivo = new FileReader(prog1);
        BufferedReader lee = new BufferedReader(archivo);
        while((cadena = lee.readLine())!=null) 
        {
            //QUITAMOS ESPACIOS INECESARIOS DEL ARCHIVO ANTES DE ALMACENARLOS EN EL ARRAYLIST
            java.util.StringTokenizer tokens = new java.util.StringTokenizer(cadena);
            cadena = "";
            while(tokens.hasMoreTokens())
            {
            cadena += " "+tokens.nextToken();
            }
            cadena = cadena.toString();
            cadena = cadena.trim();
            leerLineas.add(cadena);
        }
        lee.close();
        return leerLineas;
    }
}