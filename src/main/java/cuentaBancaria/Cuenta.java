/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentaBancaria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon Hernandez Solis
 */
public class Cuenta extends Thread{
    //Atributos
    private static double saldo =0;
    //Constructor
    public Cuenta(String name) {
        super(name);
        saldo = 0;
    }
    //Metodos
    @Override
    public void run() {
        if(getName().equals("Deposito 1")||getName().equals("Deposito 2")){
            this.depositarDinero(100);
        }else{
            this.retirarDinero(50);
        }
        System.out.println("Termina el Hilo "+getName());
    }
    public synchronized void depositarDinero(double monto){
        saldo += monto;
        System.out.println("Se depositaron "+monto+" pesos, \nsaldo = "+saldo);
        notifyAll();
    }
    public synchronized void retirarDinero(double monto){
        if (saldo<=0){
            System.out.println(getName()+" no tiene saldo, \nsaldo = "+saldo);
            try {
                sleep(5000);
                System.out.println("Saldo Final "+saldo);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        saldo -= monto;
        System.out.println(getName()+" retiro "+monto+" pesos\nSaldo restante "+saldo);
        notifyAll();
    }
    
    public static void main(String[] args) {
        new Cuenta("Retiro 1").start();
        new Cuenta("Retiro 2").start();
        new Cuenta("Deposito 1").start();
        new Cuenta("Deposito 2").start();
    }
}