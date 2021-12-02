/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poop12;
import cuentaBancaria.Cuenta;
/**
 *
 * @author Brandon Hernandez Solis
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("########Thread########");
        HiloT miHilo1 = new HiloT("Primer Hilo");
        miHilo1.start();
        new HiloT("Segundo Hilo").start();
        System.out.println("Termina por primera vez el Hilo principal");
        
        System.out.println("########Runnable########");
        HiloR miHilo3 = new HiloR();
        new Thread(miHilo3,"Tercer Hilo").start();
        new Thread(new HiloR(),"Cuarto Hilo").start();
        System.out.println("Termina por segunda vez el Hilo principal");
        
        System.out.println("########ThreadGroup########");
        ThreadGroup grupoHilos = new ThreadGroup("Grupo con prioridad normal");
        Thread hilo1 = new EjercicioThreadGroup(grupoHilos,"Hilo 1 con prioridad maxima");
        Thread hilo2 = new EjercicioThreadGroup(grupoHilos,"Hilo 2 con prioridad normal");
        Thread hilo3 = new EjercicioThreadGroup(grupoHilos,"Hilo 3 con prioridad normal");
        Thread hilo4 = new EjercicioThreadGroup(grupoHilos,"Hilo 4 con prioridad normal");
        Thread hilo5 = new EjercicioThreadGroup(grupoHilos,"Hilo 5 con prioridad normal");
        hilo1.setPriority(Thread.MAX_PRIORITY);
        grupoHilos.setMaxPriority(Thread.NORM_PRIORITY);
        System.out.println("Prioridad del grupo = "+grupoHilos.getMaxPriority());
        System.out.println("Prioridad del hilo 1 = "+hilo1.getPriority());
        System.out.println("Prioridad del hilo 2 = "+hilo2.getPriority());
        System.out.println("Prioridad del hilo 3 = "+hilo3.getPriority());
        System.out.println("Prioridad del hilo 4 = "+hilo4.getPriority());
        System.out.println("Prioridad del hilo 5 = "+hilo5.getPriority());
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        listaHilos(grupoHilos);
    }
    
    public static void listaHilos(ThreadGroup grupoActual){
        int numHilos;
        Thread[] listaHilos;
        numHilos = grupoActual.activeCount();
        listaHilos = new Thread[numHilos];
        grupoActual.enumerate(listaHilos);
        System.out.println("\nNumero de Hilos activos ="+numHilos+"\n");
        for (int i = 0; i < numHilos; i++) {
            System.out.println("Hilo activo "+i+" = "+listaHilos[i].getName());
        }
    }
}