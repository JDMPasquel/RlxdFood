/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.rlxdfood.client.access;

import co.edu.unicauca.rlxdfood.client.infra.Utilities;

/**
 *
 * @author ASUS
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta del repositorio
     *
     * @return una clase hija del repositorio
     */
    public IComponentRepository getDishService() {

        IComponentRepository result = null;
        String type = Utilities.loadProperty("repo.service");

        switch (type) {
            case "default":
                result = new ComponentRepositoryImplJersey();
                break;
        }

        return result;

    }
}
