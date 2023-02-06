/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
import java.util.regex.Pattern; //LIBRERIA QUE PERMITE EVALUAR MEDIANTE EXPRESIONES REGULARES LOS PARAMETROS DADOS
public class Expresiones
{
	//EXPRESION REGULAR PARA VALIDAR SI UN NUMERO ENTERO O NO
	public boolean Constante(String Numero)
	{
		if(Pattern.matches("[0-9]+", Numero))
			return true;
		else
			return false;
	}
	//EXPRESION REGULAR PARA VALIDAR SI UN IDENTIFICADOR VALIDO O NO
	public boolean ID(String Identificador)
	{
		if(Pattern.matches("[a-zA-Z][a-zA-Z0-9_]*", Identificador))
			return true;
		else
			return false;
	}
}