import java.util.ArrayList;

public class Conta {

    private ArrayList<Transacao> transacoes =  new ArrayList<>();

    private double saldo;
    private String nome;
    private String senha;
    private final int numero;

    private void validarNome(String nome){
        if (nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio");

        if (!nome.matches("[\\p{L}\\s]+"))
            throw new IllegalArgumentException("Nome deve conter apenas letras e espaços");
    }

    private void validarSenha(String senha){
        if (senha.length()<6)
            throw new IllegalArgumentException("Sua senha deve ter pelo menos 6 caracteres");
        if (!senha.matches("[\\p{L}\\d@#!*]+"))
            throw new IllegalArgumentException("Sua senha pode conter apenas letras, números e caracteres esp.(@#!*");
    }

    private void validarSaldo(double saldo){
        if (saldo < 0) 
            throw new IllegalArgumentException("Saldo inválido");
    }

    public Conta(int numero, String nome, String senha, double saldo){

        validarNome(nome);
        validarSenha(senha);
        validarSaldo(saldo);

        this.nome=nome;
        this.senha=senha;
        this.saldo=saldo;
        this.numero=numero;
    }    

    public boolean creditar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            Transacao transacao = new Transacao(
                TipoTransacao.DEPOSITO,
                valor,
                nome,
                numero
            );
            registrarTransacao(transacao);
            return true;
        } else {
            return false;
        }
    }

    public boolean debitar(double valor){
        if (valor > 0 && saldo >= valor) {
                saldo = saldo - valor;
                Transacao transacao = new Transacao(
                    TipoTransacao.SAQUE,
                    valor,
                    nome,
                    numero
                );
                registrarTransacao(transacao);
                return true;
        }
        else return false;
    }

    private void registrarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public String getNome(){
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero(){
        return numero;
    }

    public boolean verificaSenha(String senhaDigitada){
        return senhaDigitada.equals(senha);
    }

    public void adicionarTransacao(Transacao transacao) {
        registrarTransacao(transacao);
    }

    public void imprimeExtrato() {
        for (Transacao transacao : transacoes) {
            transacao.imprimeTransacao();
        }
    }

    public boolean debitarTransferencia(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }

        return false;
    }

    public void creditarTransferencia(double valor) {
        saldo += valor;
    }
}