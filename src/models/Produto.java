package models;

import java.util.Objects;

public class Produto {
    private static int contador = 1;
    private int id;
    private String nome;
    private double preco;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && Double.compare(preco, produto.preco) == 0 && Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }

    public Produto(String nome, double preco) {
        this.id = contador ++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto: " + "id = " + id + ", nome = " + nome + ", preço = " + preco + ".";
    }
}