import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class PersistenciaContas {

    public ArrayList<Conta> carregarContas(){

        ArrayList<Conta> contas =  new ArrayList<>();
        Path caminho = Path.of("contas.txt");

        if (!Files.exists(caminho)){
            return contas;
        }

        try{
            List<String> linhas = Files.readAllLines(caminho);
            for (String linha : linhas) {
                String[] dados = linha.split(";");
                int numero = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String senha = dados[2];
                double saldo = Double.parseDouble(dados[3]);

                Conta conta = new Conta(numero,nome,senha,saldo);
                contas.add(conta);
            }
        } catch (IOException e){
            throw new RuntimeException("Erro ao ler o arquivo de contas.", e);
        }
        return contas;
    }


    public void salvarContas(ArrayList<Conta> contas){

        ArrayList<String> linhas =  new ArrayList<>();
    
        for (Conta conta : contas){
            int numero = conta.getNumero();
            String nome = conta.getNome();
            String senha = conta.getSenha();
            double saldo = conta.getSaldo();

            linhas.add (numero + ";" + nome + ";" + senha + ";" + saldo);
        }

        Path caminho = Path.of("contas.txt");

        try{
            Files.write(caminho, linhas);
        } catch (IOException e){
            System.out.println("Erro ao gravar as contas no arquivo.");
        }
    }
}

