package models;

import java.util.Objects;

public class Cliente {
    public static int contador = 1;
    private int id;
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public Cliente(String nome) {
        this.id = contador ++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " (ID: " + id + ")";
    }
}
