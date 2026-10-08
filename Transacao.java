import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Transacao {

    private TipoTransacao tipo;
    private double valor;
    private String pessoa;
    private int numeroConta;
    private LocalDateTime data;

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transacao(TipoTransacao tipo, double valor, String pessoa, int numeroConta) {
        this.tipo = tipo;
        this.valor = valor;
        this.pessoa = pessoa;
        this.numeroConta = numeroConta;
        this.data = LocalDateTime.now();
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getPessoa() {
        return pessoa;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void imprimeTransacao() {
        System.out.println(
            tipo + " | R$ " + valor +
            " | Conta: " + numeroConta +
            " | " + pessoa +
            " | " + data.format(FORMATO_DATA)
        );
    }
}