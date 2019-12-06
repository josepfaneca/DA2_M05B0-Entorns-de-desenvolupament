package proves;

@SuppressWarnings("serial")

public class NotaIncorrectaException extends Exception{
	
	
	public NotaIncorrectaException(String missatge) {
        super(missatge);
    }
}