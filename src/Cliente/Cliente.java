package Cliente;

import java.util.ArrayList;
import java.util.List;
import Conta.ContaCorrente;
import Conta.Conta;
import Conta.ContaPoupanca;

/* Aqui deve-se:
- Adicionar/ remover conta
- pesquisar clientes
- exibir lista de clientes
 * por enquanto nao havera atualizacao de clientes
 */
public class Cliente {

    private String nome;
    private int cpf;
    private List<Conta> listaConta;

    public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public Cliente(){
        listaConta = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente= " + nome + " cpf= " + cpf;
    }
    //Abertura de conta corrente
    public void abrirContaCorrente(String nome, int cpf){
        Conta cc = new ContaCorrente(new Cliente(nome, cpf));
        listaConta.add(cc);
    }
    public void encerrarConta(Conta conta){
        listaConta.remove(conta);
    }
    //Abertura de conta Poupanca
    public void abrirContaPoupanca(String nome, int cpf){
        Conta cc = new ContaPoupanca(new Cliente(nome, cpf));
        listaConta.add(cc);
    }
    
    
    public void exibirLista(){
        System.out.println(listaConta);
    }
    
    public Object selecionarConta(int refConta){
        Conta cc = null;
        if (!listaConta.isEmpty()){
            for(Conta c: listaConta){
                if(c.getNumeroConta() == refConta){
                    cc = c;
                    break;
                }
            }
            if(cc == null){
                System.out.println("Conta inexistente");
            }
        }
        return cc;
    }
    /* --Esse metodo carece de melhoria.
    public Object selecionarCliente(int cpf){
        Conta cc = null;
        if (!listaConta.isEmpty()){
            for(Conta c: listaConta){
                if(c.getCliente().getCpf() == cpf){
                    cc = c;
                }
            }
            if(cc == null){
                System.out.println("Nao existe cliente cadastrado");
            }
        }
        return cc;
    }
*/
    

}
