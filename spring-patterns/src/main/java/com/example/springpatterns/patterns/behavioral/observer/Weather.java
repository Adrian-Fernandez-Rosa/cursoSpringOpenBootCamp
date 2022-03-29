package com.example.springpatterns.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Weather que notifica del cambio de tiempo a los observadores
 * One Weather - To - Many Observers
 */
public class Weather {
 
    private WeatherType currentWeather;
    // One to Many
    private List<WeatherObserver> observers;

    public Weather(){
        this.observers = new ArrayList<>();
    }

    public void addObserver(WeatherObserver obs){
        System.out.println("A�adido obs");
        this.observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs){
        System.out.println("Removed Observer");
        this.observers.remove(obs);
    }

    /**
     * Cambia el tiempo y notifica a los observadores asociados.
     * @param currentWeather
     */
    void changeWeather(WeatherType currentWeather){
        this.currentWeather = currentWeather;
        this.notifyObservers(); //notifica
    }

    // notificar del cambio de tiempo
    private void notifyObservers(){
        // polimorfismo, se tratan los observadores como objetos WeaterObserver (comentario por si me toca mentorear)
        for (WeatherObserver observer: this.observers) {
            observer.update(this.currentWeather);
        }
    }
}
