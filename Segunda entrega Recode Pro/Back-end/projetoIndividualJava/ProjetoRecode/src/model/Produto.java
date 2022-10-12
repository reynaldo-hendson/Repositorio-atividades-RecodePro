package model;

public class Produto {
    private int IdProduto;
    private String Descricao;
    private double ValorUnit;

    public Produto(){

    }

    public Produto(int idProduto, String descricao, double valorUnit) {
        IdProduto = idProduto;
        Descricao = descricao;
        ValorUnit = valorUnit;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getValorUnit() {
        return ValorUnit;
    }

    public void setValorUnit(double valorUnit) {
        ValorUnit = valorUnit;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "IdProduto=" + IdProduto +
                ", Descricao='" + Descricao + '\'' +
                ", ValorUnit=" + ValorUnit +
                '}';
    }
}
