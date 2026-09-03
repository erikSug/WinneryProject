package br.com.fiap.winery;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationClient1 {
    public static void main(String[] args) throws MalformedURLException {
        String wsdl = "http://localhost:8085/WineStockService?wsdl";
        String targetNameSpace = "http://winery.fiap.com.br/";
        String localPart = "WineStockServiceImplementationService";

        QName qName = new QName(targetNameSpace, localPart);
        URL url = new URL(wsdl);
        Service service = Service.create(url, qName);
        WineStockService wineStockService = service.getPort(WineStockService.class);

        String menu = wineStockService.getMenu();
        System.out.println(menu);
    }
}
