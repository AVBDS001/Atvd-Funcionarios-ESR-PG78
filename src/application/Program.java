package application;

import entities.Funcionario;
import entities_exceptions.FuncionarioExceptions;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        char saida = 'N';
        while (saida != 'S') {
            try {
                System.out.print("Insira o nome do funcionário: ");
                String nome = sc.nextLine();

                System.out.println("Insira o nível do funcionário");
                System.out.println("E --> Estagiário"
                                   + "\nF --> Funcionário "
                                   + "\nG --> Gerente ");
                char nivelCargo = sc.next().charAt(0);
                System.out.println();

                System.out.println("Tabela de salários");
                System.out.println("Nível E --> R$ 1200.00"
                                   + "\nNível F --> R$ 3500.00"
                                   + "\nNível G --> R$ 5000.00");
                System.out.print("Insira o valor do salario base do funcionário baseado na tabela acima: ");
                double salarioBase = sc.nextDouble();
                Funcionario funcionario = new Funcionario(nome, salarioBase, nivelCargo);

                //Calculando salarios e acrescentando adicional caso o funcionário não tenha direito ainda assim será mostrado o mesmo menu logo setei p true
                System.out.println();
                System.out.print("Salário total com todos descontos e adicionais: R$ " + funcionario.calculaDescontos());
                System.out.println();

                //Validação do cargo
                funcionario.validaCargo();

                //Validação do salário
                funcionario.validaSalario();

                System.out.println();
                funcionario.menuFolhaPagamento();

                System.out.println();
                System.out.print("Deseja sair do menu de seleção de funcionário: (Aperte S --> SIM / Aperte N --> NAO): ");
                saida = sc.next().charAt(0);

            }
            catch (FuncionarioExceptions e) {
                System.out.println(e.getMessage());
            }
            sc.nextLine();
        }
        sc.close();
    }
}