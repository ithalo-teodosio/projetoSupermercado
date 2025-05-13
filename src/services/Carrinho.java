package services;

import models.ItemCarrinho;
import models.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Carrinho {
    private ArrayList<ItemCarrinho> itens = new ArrayList<>();
    private HashMap<Integer, ItemCarrinho> buscaId = new HashMap<>();
    private Stack<ItemCarrinho> historico = new Stack<>();

    public void adicionarItem(Produto produto, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itens.add(item);
        buscaId.put(produto.getId(), item);
        historico.push(item);
        System.out.println("Item adicionado ao carrinho: " + item + " X " + quantidade + ".");
    }

    public void removerItem() {
        if (!historico.isEmpty()) {
            ItemCarrinho item = historico.pop();
            itens.remove(item);
            buscaId.remove(item.getProduto().getId());
            System.out.println("Item removido do carrinho: " + item + ".");
        } else {
            System.out.println("Não há itens para serem removidos do carrinho.");
        }
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho está vazio, não há itens para serem listados.");
            return;
        }

        System.out.println("Itens do carrinho: ");
        double total = 0;
        for (ItemCarrinho item : itens) {
            System.out.println("- " + item);
            total += item.getSubTotal();
        }
        System.out.println("Total: R$" + total + ".");
    }
}
