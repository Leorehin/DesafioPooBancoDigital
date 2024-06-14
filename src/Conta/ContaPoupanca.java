package Conta;

import Cliente.Cliente;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        numeroConta += 100000;
        }
    
    
}
