import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        Conta conta1 = new Conta();
        while (true) {
            System.out.println("1. Criar conta ");
            System.out.println("2. Consultar saldo ");
            System.out.println("3. Consultar cheque especial ");
            System.out.println("4. Depositar dinheiro");
            System.out.println("5. Sacar dinheiro");
            System.out.println("6. Pagar boleto");
            System.out.println("7. Status cheque especial");
            System.out.println("8. Sair");
            System.out.print("Escolha sua opção: ");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                conta1.criarConta(20);
            } else if (escolha == 2) {
                System.out.println("Saldo atual da conta: R$" + conta1.getSaldo());
            } else if (escolha == 3) {
                System.out.println("Valor disponivel para Cheque Especial: R$" + conta1.getChequeEspecial());
            } else if (escolha == 4) {
                System.out.print("Digite o valor de deseja depositar: ");
                double deposito = scanner.nextDouble();
                conta1.depositar(deposito);
            } else if (escolha == 5) {
                System.out.print("Digite o valor que deseja sacar: R$");
                double saque = scanner.nextDouble();
                conta1.sacar(saque);
            } else if (escolha == 6) {
                System.out.print("Digite o valor do boleto: R$");
                double valorBoleto = scanner.nextDouble();
                conta1.pagarBoleto(valorBoleto);
            } else if (escolha == 7) {
                System.out.printf("O valor atual disponivel do seu Cheque Especial é de: R$%s\n", conta1.getChequeEspecial());
            } else if (escolha == 8) {
                System.out.println("Saindo da aplicação...");
                break;
            } else {
                System.out.println("\nOpção inválida, Tente novamente....\n");
            }
        }
    }
}