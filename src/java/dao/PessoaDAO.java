package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Pessoa;

/**
 * DAO "de mentirinha": guarda as pessoas numa lista em memória.
 * A lista é static para ser compartilhada entre todas as requisições
 * (cada requisição cria um novo PessoaDAO, mas a lista é uma só).
 * Em um sistema real, aqui entraria o banco de dados.
 * Se o servidor for reiniciado, a lista volta a ficar vazia.
 */
public class PessoaDAO {

    private static final List<Pessoa> pessoas = new ArrayList<>();

    public void inserir(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public boolean existe(String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    // Devolve uma cópia para ninguém mexer na lista original por fora
    public List<Pessoa> listar() {
        return new ArrayList<>(pessoas);
    }

    // Mesma técnica do exercício ListaRemove: remover com Iterator
    public boolean remover(String cpf) {
        Iterator<Pessoa> it = pessoas.iterator();
        while (it.hasNext()) {
            Pessoa p = it.next();
            if (p.getCpf().equals(cpf)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
