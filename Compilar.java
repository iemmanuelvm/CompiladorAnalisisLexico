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
public class Compilar 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        LeerArchivo leer = new LeerArchivo();
        ImprimirTokens Analiza = new ImprimirTokens();
        String NombreArchivo ="";
        if(args.length>0)
        {
            NombreArchivo = args[0];
            File fichero = new File(NombreArchivo);
            if(fichero.exists())
            {
                ArrayList<String> LineasTexto=leer.muestraContenido(NombreArchivo);
                Analiza.Imprimir(LineasTexto, NombreArchivo);
            }
            else
            {
                System.out.println("NO EXISTE EL FICHERO: "+args[0]);
            }
        }
        else
            System.out.println("NO SE COMPILO NINGUN FICHERO");
    }
   
}