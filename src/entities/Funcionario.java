package entities;

import entities_exceptions.FuncionarioExceptions;
public class Funcionario {
    private String nome;
    private Double salarioBase;
    private Character nivelCargo;

    public Funcionario() {
    }
    
    public Funcionario(String nome, Double salarioBase, Character nivelCargo) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.nivelCargo = nivelCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Character getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(Character nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public Double adicional(double porcentagemAdicional, double salarioBase) {
        return salarioBase * porcentagemAdicional / 100;
    }

    public Double impostoRenda(double porcentagemIR, double salarioBase) {
        return salarioBase * porcentagemIR / 100;
    }

    public Double INSS(double porcentagemINSS, double salarioBase) {
        return salarioBase * porcentagemINSS / 100;
    }

    public Double calculaDescontos() {
        if (nivelCargo == 'G') {
            return salarioBase + adicional(15, salarioBase) - INSS(11, salarioBase) - impostoRenda(20, salarioBase);
        }
        else if (nivelCargo == 'F') {
            return salarioBase + adicional(10, salarioBase) - INSS(9, salarioBase) - impostoRenda(7.5, salarioBase);
        }
        else if (nivelCargo == 'E') {
            return salarioBase - INSS(5, salarioBase) - impostoRenda(0, salarioBase);
        }
        else  {
            return 0.0;
        }
    }

    public void validaCargo() {
        if (nivelCargo != 'G' && nivelCargo != 'F' && nivelCargo != 'E') {
            throw new FuncionarioExceptions("ERRO: O CARGO SELECIONADO É INVÁLIDO");
        }
    }

    public void validaSalario() {
        if ((nivelCargo == 'E' && salarioBase != 1200.00) || (nivelCargo == 'F' && salarioBase != 3500.00) || (nivelCargo == 'G' && salarioBase != 5000.00)) {
            throw new FuncionarioExceptions("ERRO: INSIRA A QUANTIDADE DE DINHEIRO BASEADA NA TABELA");
        }
    }

    public void menuFolhaPagamento() {
        if (nivelCargo == 'E') {
            System.out.println("Nome do funcionário: " + nome
                              +"\nSalario base: R$ " + salarioBase
                              +"\nNivel do cargo: " + nivelCargo
                              +"\nDesconto INSS: " + INSS(5, salarioBase)
                              +"\nDesconto Imposto de Renda: " + impostoRenda(0,salarioBase)
                              +"\nAdicional sobre o salário: " + adicional(0, salarioBase)
                              +"\nSalario Final: " + calculaDescontos());
        }
        else if (nivelCargo == 'F') {
            System.out.println("Nome do funcionário: " + nome
                    +"\nSalario base: R$ " + salarioBase
                    +"\nNivel do cargo: " + nivelCargo
                    +"\nDesconto INSS: " + INSS(9, salarioBase)
                    +"\nDesconto Imposto de Renda: " + impostoRenda(7.5, salarioBase)
                    +"\nAdicional sobre o salário: " + adicional(15, salarioBase)
                    +"\nSalario Final: " + calculaDescontos());
        }
        else if (nivelCargo == 'G') {
            System.out.println("Nome do funcionário: " + nome
                    +"\nSalario base: R$ " + salarioBase
                    +"\nNivel do cargo: " + nivelCargo
                    +"\nDesconto INSS: " + INSS(11, salarioBase)
                    +"\nDesconto Imposto de Renda: " + impostoRenda(20, salarioBase)
                    +"\nAdicional sobre o salário: " + adicional(15, salarioBase)
                    +"\nSalario final: " + calculaDescontos());
        }
        else {
            System.out.println("Não foi possível calcular a folha de pagamento");
        }
    }
    /* Tive que comentar esse toString pois houve um erro na implementação dele, para poder imprimir a folha de pagamento usarei uma função void (Não é uma boa prática mas é o que da p fazer)
    @Override
    public String toString() {
        return "Nome do Funcionário: " + nome
                +"\nSalario Base: R$" + salarioBase
                +"\nNivel do cargo: " + nivelCargo
                +"\nDesconto INSS: ";
    }
    */
}