
public interface Hardware {
	public String pegarNumeroDaContaCartao() throws ErroNumeroContaException;

	public void entregarDinheiro() throws ErroEntregarDinheiroException;

	public void lerEnvelope() throws ErroLerEnvelopeException;

}
