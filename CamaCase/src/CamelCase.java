import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class CamelCase {

	private static final String COMECA_COM_NUMERO_EXCEPTION = "Palavra não pode começar com um número";
	private static final String CHARACTER_EXCEPTION = "Palavra não pode conter Characteres especiais";
	private static final String PALAVRA_VAZIA_EXCEPTION = "Palavra não pode ser vazia";
	static List<String> resultados = new ArrayList<String>();

	public static List<String> converteCamelCase(String original) throws PalavraVaziaException, ComecaComNumeroException, CharacterInvalidoException {
		palavraVazia(original);
		comecaComNumero(original);
		caractereInvalido(original);
		separadorDePalavras(original);

		return resultados;
	}

	private static void separadorDePalavras(String original) {
		String palavraFormada = "";
		for (int i = 0; i < original.length(); i++) {
			char letra = original.charAt(i);
			palavraFormada = trataEntradaDeNumero(original, palavraFormada, i);
			if (isUpperCase(letra) && !isPrimeiraLetra(i)) {
				resultados.add(palavraFormada);
				palavraFormada = "";
			}
			palavraFormada += letra;
		}
		resultados.add(palavraFormada.toLowerCase());
	}

	private static String trataEntradaDeNumero(String original, String palavraFormada, int i) {
		if (Character.isDigit(original.charAt(i)) && !Character.isDigit(original.charAt(i - 1))) {
			resultados.add(palavraFormada.toLowerCase());
			palavraFormada = "";
		}
		return palavraFormada;
	}

	private static void caractereInvalido(String original) throws CharacterInvalidoException {
		boolean validacao = original.matches(".*\\W.*");
		if (validacao) {
			throw new CharacterInvalidoException(CHARACTER_EXCEPTION);
		}
	}

	private static void comecaComNumero(String original) throws ComecaComNumeroException {
		String primeiraLetra = Character.toString(original.charAt(0));
		if (primeiraLetra.matches("[0-9]"))
			throw new ComecaComNumeroException(COMECA_COM_NUMERO_EXCEPTION);
	}

	private static void palavraVazia(String original) throws PalavraVaziaException {
		if (original.isEmpty()) {
			throw new PalavraVaziaException(PALAVRA_VAZIA_EXCEPTION);
		}
	}

	private static boolean isPrimeiraLetra(int i) {
		return i == 0;
	}

	public static boolean isUpperCase(char letra) {
		return Character.toString(letra).matches("[A-Z]");
	}
}
