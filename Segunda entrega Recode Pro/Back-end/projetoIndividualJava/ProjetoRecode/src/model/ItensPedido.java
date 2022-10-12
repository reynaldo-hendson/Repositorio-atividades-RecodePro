package model;

public class ItensPedido {
    private int IdItem;
    private int Numpedido;
    private int IdProduto;
    private double quantidade;


    public ItensPedido(){


    }

    public ItensPedido(int idItem, int numpedido, int idProduto, double quantidade) {
        IdItem = idItem;
        Numpedido = numpedido;
        IdProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdItem() {
        return IdItem;
    }

    public void setIdItem(int idItem) {
        IdItem = idItem;
    }

    public int getNumpedido() {
        return Numpedido;
    }

    public void setNumpedido(int numpedido) {
        Numpedido = numpedido;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItensPedido{" +
                "IdItem=" + IdItem +
                ", Numpedido=" + Numpedido +
                ", IdProduto=" + IdProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
