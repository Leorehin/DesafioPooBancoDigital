import Cliente.Cliente;
import Conta.Conta;

public class Banco {
    public String nome = "Banco Leorehin S/A";    
    
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Conta conta = null;
        Conta contaDestino = null;
        cliente.abrirContaCorrente("Leonardo Rehin", 123456789);
        cliente.abrirContaCorrente("Maria Rosania", 321654987);
        //cliente.abrirContaCorrente("Carina Mascarenhas", 987654321);
        //cliente.abrirContaCorrente("Osvaldo Rehin", 456123789);
        //cliente.abrirContaPoupanca("Leonardo Rehin", 123456789);
        cliente.abrirContaPoupanca("Carina Mascarenhas", 987654321);
        cliente.abrirContaPoupanca("Osvaldo Rehin", 456123789);
        
        cliente.exibirLista();
        
        conta = (Conta) cliente.selecionarConta(100003);
        //cliente.encerrarConta(conta);
        
        System.out.println(conta.getSaldo());
        
        conta.depositar(1000);
        conta.sacar(100);
        System.out.println(conta.toString());
        contaDestino = (Conta) cliente.selecionarConta(1);
        
        conta.transferir(conta, contaDestino, 250);
        System.out.println(conta.toString()+"\n"+contaDestino.toString());
    }

}
