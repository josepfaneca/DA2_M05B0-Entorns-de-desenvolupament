package proves;

public class Notes {

    public static String qualificacio(int nota) throws NotaIncorrectaException{
	      
	if(nota>=0 && nota<=10){
	     if(nota>=9) return "Molt b�";
	     else if(nota>=6) return "B�";
	     else if(nota>=5) return "Normal";
	     else return "Has de millorar";
	}			   
      else throw new NotaIncorrectaException("Nota " + nota + " incorrecta.");         	            
   }	
}