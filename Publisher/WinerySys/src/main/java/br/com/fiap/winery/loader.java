package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class loader {
    static void main(String[] args) {
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        Endpoint.publish("http://localhost:8085/WineStockService",wineStock);

        System.out.println("Serviço Publicado!");
    }

}
