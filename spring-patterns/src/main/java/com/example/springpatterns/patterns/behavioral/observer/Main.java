package com.example.springpatterns.patterns.behavioral.observer;

public class Main {

	public static void main(String[] args) {
        Weather aemet = new Weather();

        // Se crean los observadores y se añaden a la clase principal para que puedan ser notificados cuando haya cambios.
        WeatherObserver computer = new Computer();
        aemet.addObserver(computer);
        aemet.addObserver(new SmartPhone());

        // cambio de tiempo y notificación automática a los observadores
        aemet.changeWeather(WeatherType.CLOUDY);
        aemet.changeWeather(WeatherType.RAINY);
        aemet.changeWeather(WeatherType.SUNNY);

        aemet.removeObserver(computer);
        aemet.changeWeather(WeatherType.SUNNY);
	}
}
