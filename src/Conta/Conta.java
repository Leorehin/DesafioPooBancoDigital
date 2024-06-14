package Conta;


import Cliente.Cliente;

/* A conta deve conter um cliente, agencia e conta em que a conta nao deve ser repetir nunca e cada cliente possui apenas uma conta de cada tipo.

- adicionar conta corrente ou poupanca para UM cliente. Pode haver cliente sem conta, mas nunca conta sem cliente
- deve exibir saldo
- depositar saldo
- sacar saldo
- transferir saldo

 * A regra de agencia sera baseado em agencia digital, ou seja, agencia 0001.
 */
public abstract class Conta {
    
    private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numeroConta;
	private double saldo;
	protected Cliente cliente;

    


    @SuppressWarnings("static-access")
    public Conta(Cliente cliente) {
		this.agencia = this.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
        this.saldo = 0;
	}
    
    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
    // Exibe Saldo
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public String toString() {
        return "Conta [agencia=" + agencia + ", conta=" + numeroConta + ", saldo=" + saldo + " "+ cliente.toString()+ "]";
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        if(validarSaldo(valor)){saldo -= valor;}
    }

    public void transferir(Conta conta, Conta contaDestino, double valor){
        if(conta.validarSaldo(valor)){
            conta.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    private boolean validarSaldo(double valor){
        if (saldo - valor > 0){
            return true;
        }
        else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

}
