package cat.pedrapapertisora.app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.wb.swt.SWTResourceManager;


public class PedraPaperTisora {

	protected Shell shlPedraPaperTisores;
	private Button btnPedra;
	private Button btnPaper;
	private Button btnTisores;
	private Label lblPuntuacio;
	private Button btnReiniciar;
	private Label lblJugador;
	private Label lblOrdinador;
	private static Text textJugador;
	private Text textOrdinador;
	private StyledText styledTextResultat;
	private Random generador;

	private int marcadorUsuari;
	private int marcadorOrdinador;
	private final int TIRADES = 5;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PedraPaperTisora window = new PedraPaperTisora();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPedraPaperTisores.open();
		shlPedraPaperTisores.layout();
		while (!shlPedraPaperTisores.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPedraPaperTisores = new Shell();
		shlPedraPaperTisores.setSize(276, 446);
		shlPedraPaperTisores.setText("Pedra, Paper, Tisores");

		btnPedra = new Button(shlPedraPaperTisores, SWT.NONE);
		btnPedra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String decisioOrdinador = respostaOrdinador();
				String resultat = logicaJoc("PEDRA", decisioOrdinador);
				if (marcadorOrdinador < TIRADES && marcadorUsuari < TIRADES) {
					textJugant (resultat, marcadorUsuari, marcadorOrdinador);
				} else {
					textFinal (resultat, marcadorUsuari, marcadorOrdinador);
					marcadorOrdinador = 0;
					marcadorUsuari = 0;
				}
			}
		});
		btnPedra.setBounds(10, 49, 75, 25);
		btnPedra.setText("Pedra");

		btnPaper = new Button(shlPedraPaperTisores, SWT.NONE);
		btnPaper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String decisioOrdinador = respostaOrdinador();
				String resultat = logicaJoc("PAPER", decisioOrdinador);
				if (marcadorOrdinador < TIRADES && marcadorUsuari < TIRADES) {
					textJugant (resultat, marcadorUsuari, marcadorOrdinador);
				} else {
					textFinal (resultat, marcadorUsuari, marcadorOrdinador);
					marcadorOrdinador = 0;
					marcadorUsuari = 0;
				}
			}
		});
		btnPaper.setBounds(91, 49, 75, 25);
		btnPaper.setText("Paper");

		btnTisores = new Button(shlPedraPaperTisores, SWT.NONE);
		btnTisores.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String decisioOrdinador = respostaOrdinador();
				String resultat = logicaJoc("TISORES", decisioOrdinador);
				if (marcadorOrdinador < TIRADES && marcadorUsuari < TIRADES) {
					textJugant (resultat, marcadorUsuari, marcadorOrdinador);
				} else {
					textFinal (resultat, marcadorUsuari, marcadorOrdinador);
					marcadorOrdinador = 0;
					marcadorUsuari = 0;
				}
			}
		});
		btnTisores.setBounds(172, 49, 75, 25);
		btnTisores.setText("Tisores");

		lblPuntuacio = new Label(shlPedraPaperTisores, SWT.NONE);
		lblPuntuacio.setAlignment(SWT.CENTER);
		lblPuntuacio.setBounds(80, 107, 86, 15);
		lblPuntuacio.setText("Puntuaci\u00F3");

		btnReiniciar = new Button(shlPedraPaperTisores, SWT.NONE);
		btnReiniciar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledTextResultat.setText("");
				textJugador.setText(String.valueOf(0));
				textOrdinador.setText(String.valueOf(0));
				marcadorOrdinador = 0;
				marcadorUsuari = 0;
			}
		});
		btnReiniciar.setText("Reiniciar");
		btnReiniciar.setBounds(10, 372, 117, 25);

		lblJugador = new Label(shlPedraPaperTisores, SWT.NONE);
		lblJugador.setText("Jugador");
		lblJugador.setBounds(5, 155, 52, 15);

		lblOrdinador = new Label(shlPedraPaperTisores, SWT.NONE);
		lblOrdinador.setText("Ordinador");
		lblOrdinador.setBounds(199, 155, 55, 15);

		textJugador = new Text(shlPedraPaperTisores, SWT.BORDER | SWT.CENTER);
		textJugador.setText("0");
		textJugador.setFont(SWTResourceManager.getFont("Segoe UI", 44, SWT.NORMAL));
		textJugador.setBounds(72, 128, 55, 90);

		textOrdinador = new Text(shlPedraPaperTisores, SWT.BORDER | SWT.CENTER);
		textOrdinador.setText("0");
		textOrdinador.setFont(SWTResourceManager.getFont("Segoe UI", 44, SWT.NORMAL));
		textOrdinador.setBounds(139, 128, 55, 90);

		styledTextResultat = new StyledText(shlPedraPaperTisores, SWT.BORDER);
		styledTextResultat.setBounds(10, 232, 236, 122);

	}

	public String respostaOrdinador() {

		generador = new Random(); // crear objecte generador d’aleatoris

		int numero = generador.nextInt(3) + 1; // Generar un número aleatori enter entre 1 i 3

		String resposta;

		if (numero == 1) {
			resposta = "PEDRA";
		} else if (numero == 2) {
			resposta = "PAPER";
		} else {
			resposta = "TISORES";
		}
		return resposta;
	}

	public String logicaJoc(String decisioUsuari, String decisioOrdinador) {

		if (decisioUsuari == decisioOrdinador) {
			return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
					+ "\nHeu empatat. No puntua ningú.";
		} else {
			if (decisioUsuari == "PEDRA" && decisioOrdinador == "PAPER") {
				marcadorOrdinador++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas Perdut.";
			}
			if (decisioUsuari == "PEDRA" && decisioOrdinador == "TISORES") {
				marcadorUsuari++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas guanyat.";
			}
			if (decisioUsuari == "PAPER" && decisioOrdinador == "TISORES") {
				marcadorOrdinador++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas Perdut.";
			}
			if (decisioUsuari == "PAPER" && decisioOrdinador == "PEDRA") {
				marcadorUsuari++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas guanyat";
			}
			if (decisioUsuari == "TISORES" && decisioOrdinador == "PEDRA") {
				marcadorOrdinador++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas Perdut";
			}
			if (decisioUsuari == "TISORES" && decisioOrdinador == "PAPER") {
				marcadorUsuari++;
				return "Jugador ha triat " + decisioUsuari + "\nOrdinador ha triat " + decisioOrdinador
						+ "\nHas guanyat";
			}
		}
		return null;
	}

	public void textFinal (String resultat, int marcadorUsuari, int marcadorOrdinador) {
		textJugador.setText(String.valueOf(0));
		textOrdinador.setText(String.valueOf(0));
		styledTextResultat.setText(resultat.concat("\nJoc Acabat! Guanya ") + (marcadorUsuari > marcadorOrdinador ? "Jugador" : "Ordinador" ) );
	}
	public void textJugant (String resultat,int marcadorUsuari, int marcadorOrdinador) {
		textJugador.setText(String.valueOf(marcadorUsuari));
		textOrdinador.setText(String.valueOf(marcadorOrdinador));
		styledTextResultat.setText(resultat);

	}
}
