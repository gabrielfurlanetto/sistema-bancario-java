import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas;

    private int proximoNumeroConta = 100001;

    public Banco() {
        contas = new ArrayList<>();
    }

    public Conta buscaContaNumero(int numeroConta){
        for (Conta conta : contas){
            if (numeroConta == conta.getNumero())
                return conta;
        }
        return null;
    }

    public Conta buscaConta(String nomeConta, String senha){
        for (Conta conta : contas){
            if (nomeConta.equals(conta.getNome()) && conta.verificaSenha(senha)) 
                return conta;
        }
        return null;
    }

    public boolean adicionarConta(String nome, String senha, double saldo){

        for (Conta conta : contas) {
            if (nome.equals(conta.getNome())) {
                return false;
            }
        }

        Conta contaNova = new Conta(proximoNumeroConta, nome, senha, saldo);
        proximoNumeroConta++;
        contas.add(contaNova);

        return true;
    }

    public boolean transferir(Conta origem, Conta destino, double valor) {

        if (!origem.debitarTransferencia(valor)) {
            return false;
        }

        destino.creditarTransferencia(valor);

        origem.adicionarTransacao(
            new Transacao(
                TipoTransacao.TRANSFERENCIA_ENVIADA,
                valor,
                destino.getNome(),
                destino.getNumero()
            )
        );

        destino.adicionarTransacao(
            new Transacao(
                TipoTransacao.TRANSFERENCIA_RECEBIDA,
                valor,
                origem.getNome(),
                origem.getNumero()
            )
        );

        return true;
    }
} 