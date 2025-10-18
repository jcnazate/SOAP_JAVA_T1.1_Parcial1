package ec.edu.monster.controller;

import ec.edu.monster.model.ConUniService;

public class AppController {
    private final ConUniService service;

    public AppController() {
        this.service = new ConUniService();
    }

    public boolean login(String usuario, String contraseña) throws Exception {
        return service.login(usuario, contraseña);
    }

    public double pulgadasACentimetros(double pulgadas) throws Exception {
        return service.pulgadasACentimetros(pulgadas);
    }

    public double centimetrosAPulgadas(double centimetros) throws Exception {
        return service.centimetrosAPulgadas(centimetros);
    }

    public double kelvinACelsius(double kelvin) throws Exception {
        return service.kelvinACelsius(kelvin);
    }

    public double celsiusAKelvin(double celsius) throws Exception {
        return service.celsiusAKelvin(celsius);
    }

    public double gramosAKilogramos(double gramos) throws Exception {
        return service.gramosAKilogramos(gramos);
    }

    public double kilogramosAGramos(double kilogramos) throws Exception {
        return service.kilogramosAGramos(kilogramos);
    }
}