import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public Conta buscaConta(String nomeConta, String senha){
        for (int i=0; i<contas.size(); i++){
            Conta conta = contas.get(i);
            if (nomeConta.equals(conta.getNome()) && conta.verificaSenha(senha)) 
                return conta;
        }
        return null;
    }

    public boolean adicionarConta(Conta contaNova) {

        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);

            if (contaNova.getNome().equals(conta.getNome())) {
                return false;
            }
        }

        contas.add(contaNova);
        return true;
    }
} 