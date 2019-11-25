package MPT.mpt.DataPostgreSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

import MPT.mpt.dataSQLite.Produto;

public class produtoBD extends _default {

    private int cod_produto;
    private String marca;
    private String tipo;
    private float peso ;
    private String caracteristica;
    private float preco;
    private int qtd;
    private int cod_mercado;
    private String nome_mercado ;

    public produtoBD() {
        super();
        this.cod_produto = -1;
        this.marca = "";
        this.tipo = "";
        this.peso = 0;
        this.caracteristica = "";
        this.preco = 0;
        this.qtd = 0;
        this.cod_mercado = 0;
        this.nome_mercado  = "";
    }
    public ArrayList<produtoBD> getLista(){
        DB db = new DB();
        ArrayList<produtoBD> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT produto.cod_produto, produto.marca ,produto.tipo ,produto.peso ,produto.caracteristica ,produto.preco ,produto.qtd ,produto.cod_mercado, mercado.nome_mercado  FROM produto naturaljoin mercado ");
            if (resultSet != null){
                while (resultSet.next()){
                    produtoBD obj = new produtoBD();
                    obj.setCod_produto(resultSet.getInt("cod_produto"));
                    obj.setMarca(resultSet.getString("marca"));
                    obj.setTipo(resultSet.getString("tipo"));
                    obj.setPeso(resultSet.getFloat("peso"));
                    obj.setCaracteristica(resultSet.getString("caracteristica"));
                    obj.setPreco(resultSet.getFloat("preco"));
                    obj.setQtd(resultSet.getInt("qtd"));
                    obj.setCod_mercado(resultSet.getInt("cod_mercado"));
                    obj.setNome_mercado(resultSet.getString("nome_mercado "));
                    lista.add(obj);
                    obj = null;
                }
            }
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getCod_mercado() {
        return cod_mercado;
    }

    public void setCod_mercado(int cod_mercado) {
        this.cod_mercado = cod_mercado;
    }

    public String getNome_mercado() {
        return nome_mercado ;
    }

    public void setNome_mercado(String nm_mercado) {
        this.nome_mercado  = nm_mercado;
    }
}
