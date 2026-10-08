public class Autenticacao {

    private Banco banco;

    public Autenticacao(Banco banco) {
        this.banco = banco;
    }

    public Conta login(String nome, String senha) {
        return banco.buscaConta(nome, senha);
    }
}