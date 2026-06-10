package model;

public class Equipamento {
    private String id;
    private String nome;
    private String defeito;
    private String dataBaixa;
    
    public Equipamento() {}

    public Equipamento(String id, String nome, String defeito, String dataBaixa) {
        this.id = id;
        this.nome = nome;
        this.defeito = defeito;
        this.dataBaixa = dataBaixa;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDefeito() { return defeito; }
    public void setDefeito(String defeito) { this.defeito = defeito; }
    public String getDataBaixa() { return dataBaixa; }
    public void setDataBaixa(String dataBaixa) { this.dataBaixa = dataBaixa; }
}