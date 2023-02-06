/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
import java.util.*;
public class AnalisisLexico
{
	public Tabla Tab = new Tabla();
	public Expresiones ExpRegular = new Expresiones();
	public ArrayList<String> TokenSeparado=new ArrayList<String>();
	public ArrayList<String> TokensLinea=new ArrayList<String>();
	public String Lexema, TemporalToken;
	public boolean esComentario=false, TratarToken=true;
	public int TokenActual=0, Linea=1, i=0, j=0, PosicionTabla;
	//METODO QUE RECIBE LAS LINEAS EXTRAIDAS DEL ARCHIVO
	public void RecibirArchivo(ArrayList<String> LineasArchivo)
	{
		TokensLinea = LineasArchivo;
	}
	//METODO QUE RETORNA EL NUMERO DE LINEA QUE ESTA SEPARANDO POR TOKENS
	public int getLinea()
	{
		return Linea-1;
	}
	//METODO QUE RETORNA EL LEXEMA TALES COMO EL NUMERO ENTERO Y IDENTIFICADORES
	public String getLexema()
	{
		return Lexema;
	}
	//METODO QUE RETORNA DONDE EMPIEZA EL ERROR EN LA LINEA ANALIZADA
	public String getTokenInvalido()
	{
		return TokenSeparado.get(j);
	}
	//METODO QUE RETORNA EL NUMERO DE TOKEN
	public int AnalizadorLexico()
	{
		//SE INICIALIZA LA TABLA DE SIMBOLOS
		Tab.TablaDeSimbolos();
		for(i=Linea-1;i<TokensLinea.size();i++)
		{
			TemporalToken="";
			if(TratarToken==true)
			{
				//FOR PARA SEPARAR TOKEN POR TOKEN LOS TOKENS DE UNA LINEA
				for(j=0;j<TokensLinea.get(i).length();j++)
				{
					//SEPARAMOS TOKENS DE LA TABLA DE SIMBOLOS QUE ESTEN PEGANDOS A OTRO TOKEN
					if(TokensLinea.get(i).charAt(j)=='(')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add("(");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)==')')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add(")");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)=='+')
					{	
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add("+");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)=='-')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add("-");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)==',')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add(",");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)=='.')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add(".");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)==';')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add(";");
						TemporalToken="";
					}
					else if(TokensLinea.get(i).charAt(j)==':')
					{
						TokenSeparado.add(TemporalToken);
						TokenSeparado.add(":");
						TemporalToken="";
					}
					//OMITE ESPACIOS Y TABULADORES
					else if(TokensLinea.get(i).charAt(j)==' '  || TokensLinea.get(i).charAt(j)=='\t' || TokensLinea.get(i).charAt(j)=='\n')
					{
						TokenSeparado.add(TemporalToken);
						TemporalToken="";
					}
					else
					{
						TemporalToken=TemporalToken+TokensLinea.get(i).charAt(j);
					}
				}
				TokenSeparado.add(TemporalToken);
				TemporalToken="";
				for(j=0;j<TokenSeparado.size();j++)
				{
					if(TokenSeparado.get(j).equals(""))
					{
						TokenSeparado.remove(j);
					}
				}
				TratarToken=false;
			}
			for(j = TokenActual;j<TokenSeparado.size();j++)
			{
				//OMITE TODOS LOS TOKENS QUE ESTEN ENTRE LOS COMENTARIOS MULTILINEA Y DE UNAS SOLA LINEA
				if(esComentario==false && TokenSeparado.get(j).contains("/*"))
				{
					esComentario=true;
				}
				else if(esComentario==true && TokenSeparado.get(j).contains("*/"))
				{
					esComentario=false;
				}
				else if(esComentario==false && TokenSeparado.get(j).contains("//"))
				{
					break;
				}
				//COMPROBAMOS TOKENS
				else if(esComentario==false)
				{
					PosicionTabla = Tab.BuscarEnTablaSimbolos(TokenSeparado.get(j));
					//COMPRUEBA SI EL TOKEN ES UNA PALABRA RESERVADA 
					if(Tab.EstaEnTabla(TokenSeparado.get(j)))
					{
						TokenActual=j+1;
						PosicionTabla = Tab.BuscarEnTablaSimbolos(TokenSeparado.get(j));
						return PosicionTabla;
					}
					//COMPRUEBA SI EL TOKEN ES UN NUMERO ENTERO VALIDO
					else if(ExpRegular.Constante(TokenSeparado.get(j).charAt(0)+""))
					{
						if(ExpRegular.Constante(TokenSeparado.get(j)))
						{
							Lexema=TokenSeparado.get(j);
							PosicionTabla=Tab.BuscarEnTablaSimbolos("NumeroEntero");
							TokenActual=j+1;
							return PosicionTabla;
						}
						else
						{
							return -1;
						}
					}
					//COMPRUEBA SI EL TOKEN ES UN IDENTIFICADOR VALIDO
					else if(ExpRegular.ID(TokenSeparado.get(j)))
					{
						if(ExpRegular.ID(TokenSeparado.get(j)))
						{
							Lexema=TokenSeparado.get(j);
							PosicionTabla=Tab.BuscarEnTablaSimbolos("id");
							TokenActual=j+1;
							return PosicionTabla;
						}
						else
						{
							return -2;
						}
						
					}
					else
					{
						//SE RETORNA -3 SI EL TOKEN ES TOTALMENTE INVALIDO
						return -3;
					}
				}
				TokenActual=j+1;
			}
			Linea++;
			TokenSeparado.clear();
			TokenActual=0;
			TratarToken=true;
		}
        return -4;
	}
}