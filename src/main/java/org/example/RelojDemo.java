package org.example;

import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tiempo en segundos para la creacion del reloj: ");
        int sec = sc.nextInt();
        Reloj relo = new Reloj(sec);
        System.out.printf("%36s\n", "------------------------------------");
        System.out.println("Hora creada ------------> " + relo);
        System.out.printf("%36s\n%28s\n%36s\n", "------------------------------------", "Comenzando los ticks", "------------------------------------");
        for (int k = 1; k <= 10; k++){
            relo.tick();
            System.out.println("Tick numero " + String.format("%02d", k) + " Hora ----> " + relo);
        }
        System.out.printf("%36s\n%29s\n", "------------------------------------", "Diferencia entre horas");
        System.out.println(new Reloj(19, 45, 56) + " - " + relo + " = " + relo.restaReloj(new Reloj(19, 45, 56)));
        System.out.printf("%36s\n", "------------------------------------");
        relo.horaVerano()
        System.out.println(relo);

        sc.close();
    }
}
