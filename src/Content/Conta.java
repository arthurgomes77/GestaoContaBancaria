package Content;

public class Conta {
    private double saldo;
    private double valorChequeEspecial;
    private double chequeEspecialUsado;
    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void criarConta(double deposito) {
        this.saldo = deposito;
        if (deposito < 500) {
            this.chequeEspecial = 50.0;
            System.out.printf("Conta Criada com Sucesso, Saldo inicial - R$ %s\n", this.saldo);
            return;
        }
        this.chequeEspecial = deposito * 0.5;
        System.out.printf("Conta Criada com Sucesso, Saldo inicial - R$ %s\n", this.saldo);
    }

    public void depositar(double deposito) {
        if (this.valorChequeEspecial == 0) {
            this.saldo += deposito;
            System.out.printf("Deposito de R$ %s, feito com sucesso!\n", deposito);
            return;
        }
        this.saldo += deposito - (valorChequeEspecial * 0.2);
        System.out.printf("Seu deposito de R$ %s foi concluido, adicionamos %s, devido as cobranças do uso do Cheque Especial\n", deposito, (deposito - valorChequeEspecial * 0.2));
    }

    public void sacar(double saque) {
        if (saque > this.saldo) {
            System.out.printf("Saldo insuficiente. Valor em conta - R$ %s\n", this.saldo);
            return;
        }
        this.saldo -= saque;
        System.out.printf("Saque no valor de R$ %s, feito com sucesso!\n", saque);
    }

    public void pagarBoleto(double valorBoleto) {
        if (valorBoleto > this.saldo && valorBoleto < (this.saldo + this.chequeEspecial)) {
            this.chequeEspecial = this.chequeEspecial - (valorBoleto - this.saldo);
            this.valorChequeEspecial = (valorBoleto - this.saldo);
            this.saldo = 0;
            System.out.println("O valor do boleto é maior que o saldo atual, foi utilizado o valor do cheque especial");
            return;
        } else if (valorBoleto > this.saldo) {
            System.out.println("Valor do boleto é maior que o seu saldo atual, não conseguimos proceder com o seu pagamento");
        } else if (valorBoleto < this.saldo) {
            this.saldo -= valorBoleto;
            System.out.printf("Boleto pago com sucesso, seu saldo atual é de R$ %s\n", this.saldo);
        }

    }
}
