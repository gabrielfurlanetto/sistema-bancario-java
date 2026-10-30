import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;

public class PersistenciaTransacao {
    
    public void salvarTransacao(Transacao transacao, int numeroContaTitular){
        
        ArrayList<String> linhas =  new ArrayList<>();

        String tipo = transacao.getTipo().name();
        double valor = transacao.getValor();
        String pessoa = transacao.getPessoa();
        int numeroConta = transacao.getNumeroConta();
        String data = transacao.getData().toString();

        linhas.add(tipo + ";" + valor + ";" + pessoa + ";" + numeroConta + ";" + data + ";" + numeroContaTitular);
    
        Path caminho = Path.of("extratos.txt");

        try {
            Files.write(
                caminho,
                linhas,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Erro ao gravar as transações no arquivo.");
        }
    }

    public ArrayList<Transacao> carregarTransacoes (int numeroContaTitular){
     
        ArrayList<Transacao> transacoes = new ArrayList<>(); //cria a lista para devolve-la com os dados posteriormente

        Path caminho = Path.of("extratos.txt");

        if (!Files.exists(caminho)) {
            return transacoes;
        }

        try {
            List<String> linhas = Files.readAllLines(caminho);

            for (String linha : linhas) {
                String[] dados = linha.split(";"); //cada iteração do for, dados[0] dados[1]... será de uma nova linha
                int numeroTitular = Integer.parseInt(dados[5]);

                if (numeroTitular != numeroContaTitular) {
                    continue; //caso não for a conta que procuramos, passa pra próxima iteração do for
                } 

                TipoTransacao tipo = TipoTransacao.valueOf(dados[0]);
                double valor = Double.parseDouble(dados[1]);
                String pessoa = dados[2];
                int numeroConta = Integer.parseInt(dados[3]);
                LocalDateTime data = LocalDateTime.parse(dados[4]);

                Transacao transacao = new Transacao(tipo, valor, pessoa, numeroConta, data);
                transacoes.add(transacao);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo de transações.", e);
        }

        return transacoes;
    }
}


/*public ArrayList<Conta> carregarContas() {
      ArrayList var1 = new ArrayList();
      Path var2 = Path.of("contas.txt");
      if (!Files.exists(var2, new LinkOption[0])) {
         return var1;
      } else {
         try {
            for(String var5 : Files.readAllLines(var2)) {
               String[] var6 = var5.split(";");
               int var7 = Integer.parseInt(var6[0]);
               String var8 = var6[1];
               String var9 = var6[2];
               double var10 = Double.parseDouble(var6[3]);
               Conta var12 = new Conta(var7, var8, var9, var10);
               var1.add(var12);
            }

            return var1;
         } catch (IOException var13) {
            throw new RuntimeException("Erro ao ler o arquivo de contas.", var13);
         }
      }
   } */