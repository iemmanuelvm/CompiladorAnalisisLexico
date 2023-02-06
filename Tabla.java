/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
public class Tabla 
{
    Map<Integer, String> TablaS = new HashMap<Integer, String>();
    //METODO PARA CREAR LA TABLA DE SIMBOLOS MEDIANTE LA FUNCION HASHMAP
    public void TablaDeSimbolos() 
    {
    String[] Simbolos = {"const","var","proced", "begin", "end", "read", "write", "call", "if", "then", "while", "do", "for", "to", "dto", "id", "NumeroEntero", ".", "=", ",",
                            ";", "(", ")", "==", "!=", "<", ">", "<=", ">=", "+", "-", "*", "/"};
    int[] Clave = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        for (int i=0; i<Simbolos.length; i++) 
        {
            TablaS.put(Clave[i], Simbolos[i]);
        }
    }
    //METODO PARA RETORNAR LA CLAVE DEL TOKEN A BUSCAR EN LA TABLA DE SIMBOLOS
    public int BuscarEnTablaSimbolos(String Valor)
    {
            Iterator it = TablaS.entrySet().iterator();
            int numToken=0;
            for (Map.Entry<Integer, String> entry : TablaS.entrySet()) 
            {
                if(Valor.equals(entry.getValue()))
                {
                    numToken = entry.getKey();
                    break;
                }
                else 
                    continue;
            }
            return numToken;
    }
    //METODO SABER SI SE ENCUENTRA EL TOKEN EN LA TABLA DE SIMBOLOS
    public boolean EstaEnTabla(String Valor)
    {
            Iterator it = TablaS.entrySet().iterator();
            boolean numToken=false;

            for (Map.Entry<Integer, String> entry : TablaS.entrySet()) 
            {
                if(Valor.equals(entry.getValue()))
                {
                    numToken = true;
                    break;
                }
                else {
                    continue;
                }
            }
            return numToken;
    }
    //METODO SABER SI SE ENCUENTRA LA CLAVE EN LA TABLA DE SIMBOLOS
    public boolean EstaClave(int Valor)
    {
            Iterator it = TablaS.entrySet().iterator();
            boolean clave=false;

            if(TablaS.containsKey(Valor))
                clave = true;
            else
                clave = false;
            return clave;
    }
    //RETORNO DEL TOKEN DENTRO DE LA TABLA DE SIMBOLOS
    public String RetornoDelToken(int Valor)
    {
            return TablaS.get(Valor);
    }
}