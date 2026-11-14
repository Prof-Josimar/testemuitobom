package model;

import util.CpfUtil;

public class Pessoa {

    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Usado na tela de listagem
    public String getCpfFormatado() {
        return CpfUtil.formatar(cpf);
    }
}
