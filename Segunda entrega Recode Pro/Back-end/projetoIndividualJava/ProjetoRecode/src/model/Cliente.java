package model;


public class Cliente {
    private int id;
    private String nomeCliente;
    private String cpf;
    private String logadouro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefoneCelular;
    private String dataCadastro;

    public Cliente(){

    }


    public Cliente(int id, String nomeCliente, String cpf, String logadouro, String cidade, String uf, String cep,
                   String telefoneCelular, String dataCadastro) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.logadouro = logadouro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefoneCelular = telefoneCelular;
        this.dataCadastro = dataCadastro;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getLogadouro() {
        return logadouro;
    }
    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getTelefoneCelular() {
        return telefoneCelular;
    }
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    public String getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", logadouro=" + logadouro
                + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefoneCelular=" + telefoneCelular
                + ", dataCadastro=" + dataCadastro + "]";
    }






}