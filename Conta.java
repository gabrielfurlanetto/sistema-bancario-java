public class Conta {

    private double saldo;
    private String nome;
    private String senha;

    public Conta() {
        this.saldo = 0;
        this.nome = "Sem nome";
    }

    public Conta(String nome, String senha, double saldo){

        if (nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        if (!nome.matches("[\\p{L}\\s]+"))
            throw new IllegalArgumentException("Deve conter apenas letras e espaços");

        if (saldo < 0) 
            throw new IllegalArgumentException("Saldo inválido");

        if (senha.length()<6)
            throw new IllegalArgumentException("Sua senha deve ter pelo menos 6 caracteres");
        if (!senha.matches("[\\p{L}\\d@#!*]+"))
            throw new IllegalArgumentException("Sua senha pode conter apenas letras, números e caracteres esp.(@#!*");

        this.nome=nome;
        this.senha=senha;
        this.saldo=saldo;
    }    

    

    public Conta(String nome, double saldo) {

    this.nome = nome;

    if (saldo >= 0) {
        this.saldo = saldo;
    } 
    else {
        this.saldo = 0;
        System.out.println("Saldo inicial inválido. Conta criada com saldo R$0.");
        }
    }

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo = saldo - valor;
                System.out.println("Você sacou R$" + valor);
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public String getNome(){
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean verificaSenha(String senhaDigitada){
        return senhaDigitada.equals(senha);
    }
}