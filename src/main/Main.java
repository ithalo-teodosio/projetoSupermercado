package main;

import models.ItemCarrinho;
import models.Produto;
import services.Carrinho;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();

        boolean sair = false;

        while (!sair) {
            System.out.println("\n Bem-vindo ao supermercado APP!!!");
            System.out.println("1. Adicionar item ao carrinho.");
            System.out.println("2. Remover último item do carrinho.");
            System.out.println("3. Listar itens no carrinho.");
            System.out.println("4. Pesquisar item pelo ID.");
            System.out.println("5. Sair.");
            System.out.println("Escolha uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = scan.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double preco = scan.nextDouble();

                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = scan.nextInt();
                    scan.nextLine();

                    Produto produto = new Produto(nome, preco);
                    carrinho.adicionarItem(produto, quantidade);
                    break;

                case 2:
                    carrinho.removerItem();
                    break;

                case 3:
                    carrinho.listarItens();
                    break;

                case 4:
                    System.out.println("Digite o ID do produto: ");
                    int idBusca = scan.nextInt();
                    scan.nextLine();

                    ItemCarrinho itemEncontrado = carrinho.buscarPorId(idBusca);

                    if (itemEncontrado != null) {
                        System.out.println("Item " + itemEncontrado + " encontrado.");
                    } else {
                        System.out.println("Nenhum item encontrado com o ID informado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
