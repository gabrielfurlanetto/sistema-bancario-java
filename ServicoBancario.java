public class ServicoBancario {

    private Banco banco;
    private PersistenciaTransacao persistenciaTransacao;

    public ServicoBancario(Banco banco) {
        this.banco = banco;
        this.persistenciaTransacao = new PersistenciaTransacao();
    }

    public boolean depositar(Conta conta, double valor) {

        if (!conta.creditar(valor)) {
            return false;
        }

        Transacao transacao = conta.getUltimaTransacao();

        persistenciaTransacao.salvarTransacao(
            transacao,
            conta.getNumero()
        );

        return true;
    }

    public boolean sacar(Conta conta, double valor) {

        if (!conta.debitar(valor)) {
            return false;
        }

        Transacao transacao = conta.getUltimaTransacao();

        persistenciaTransacao.salvarTransacao(
            transacao,
            conta.getNumero()
        );

        return true;
    }

    public boolean transferir(Conta origem, Conta destino, double valor) {

        if (!banco.transferir(origem, destino, valor)) {
            return false;
        }

        Transacao transacaoEnviada = origem.getUltimaTransacao();
        Transacao transacaoRecebida = destino.getUltimaTransacao();

        persistenciaTransacao.salvarTransacao(
            transacaoEnviada,
            origem.getNumero()
        );

        persistenciaTransacao.salvarTransacao(
            transacaoRecebida,
            destino.getNumero()
        );

        return true;
    }
}