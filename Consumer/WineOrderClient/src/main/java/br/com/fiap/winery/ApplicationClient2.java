package br.com.fiap.winery;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationClient2{
    public static void main(String[] args) throws MalformedURLException {
        String wsdl = "http://localhost:8085/WineStockService?wsdl";
        String targetNameSpace = "http://winery.fiap.com.br/";
        String localPart = "WineStockServiceImplementationService";

        QName qName = new QName(targetNameSpace, localPart);
        URL url = new URL(wsdl);
        Service service = Service.create(url, qName);
        WineStockService wineStockService = service.getPort(WineStockService.class);

        String order = wineStockService.placeOrder("Vinho Tinto",1);
        System.out.println(order);

        URL url2 = new URL("http://localhost:8086/WineWarningService?wsdl");
        QName qName2 = new QName(targetNameSpace, "WineWarningServiceImplementationService");
        Service service2;
        service2 = Service.create(url2,qName2);
        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);

        String warn = wineWarningService.sendWarn();
        System.out.println(warn);
    }

}
