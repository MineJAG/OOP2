/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

import java.util.Scanner;

/**
 * Classe que representa o leitor de entrada do utilizador no jogo tem como responsabilidade ler as entradas do utilizador.
 * @author Lara
 */
public class UserInputReader {
    Scanner scanner = new Scanner(System.in);

    public String readInputLine() {
        return scanner.nextLine();
    }
    public int readInt() {
        return scanner.nextInt();
    }
}
