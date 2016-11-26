package br.com.wander.buscadorcep;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.json.simple.parser.ParseException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaCEP {

    public static String getEndereco(String CEP) throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
            for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
            }

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return CEP;
    }

    public static String getBairro(String CEP) throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("td:gt(1)");
            for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
            }

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return CEP;
    }

    public static String getCidade(String CEP) throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
            for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
            }

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return CEP;
    }

    public static String getUF(String CEP) throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
            for (Element urlUF : urlPesquisa) {
                return urlUF.text();
            }

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return CEP;
    }

    public static String getLatLong(String CEP) throws IOException, ParseException {

        // ***************************************************
        try {

            if (CEP.contains("-")) {
                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                        + CEP + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            } else {

                StringBuilder cepHif = new StringBuilder(CEP);  
                cepHif.insert(CEP.length() - 3, '-');

                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                        + cepHif + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            }

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return CEP;
    }

}