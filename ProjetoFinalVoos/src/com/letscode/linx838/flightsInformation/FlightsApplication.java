package com.letscode.linx838.flightsInformation;

import com.letscode.linx838.flightsInformation.entity.FileManager;
import com.letscode.linx838.flightsInformation.entity.Flight;
import com.letscode.linx838.flightsInformation.entity.FlightSummary;
import org.w3c.dom.ls.LSOutput;

import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class FlightsApplication {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        List<String> flightInformations = fileManager.readLines("flights.csv");
        List<Flight> stringToObject = flightInformations.stream().skip(1)
                //Substituindo expressão lambda line -> Flight.stringToFlightObject(line) com Method Reference
                .map(Flight::stringToFlightObject).collect(Collectors.toList());
        stringToObject.stream().map(Flight::getDuration);


        // Gerando o primeiro arquivo, utilizando o método objectToCsv da classe flight para realizar a separação dos atributos
        List<String> fileFlights1 = stringToObject.stream()
                .sorted(Comparator.comparing(Flight::getOrigin)
                        .thenComparing(Flight::getDestination)
                        .thenComparing(Flight::getDuration)
                        .thenComparing(Flight::getPrice)
                        .thenComparing(Flight::getAirline))
                .map(flight -> flight.objectToCsv())
                .collect(Collectors.toList());

        //Criando o diretório em que os arquivos .csv serão gerado
//      fileManager.createDirectory("Files");

        fileFlights1.add(0, "Origin;Destination;Airline;Departure;Arrival;Price;Duration");
        fileManager.writeLines("Files/StructuredFlights.csv", fileFlights1);

        //Aplicando as ordenações (duração, preço e linha aérea) através do método sorted() e
        //agrupando os vôos por Origem/Destinopara gerar o segundo arquivo
        Map<String, FlightSummary> structuredFlights = stringToObject.stream()
                .sorted(Comparator.comparing(Flight::getDuration)
                        .thenComparing(Flight::getPrice)
                        .thenComparing(Flight::getAirline))
                .collect(Collectors.groupingBy(flight -> flight.getOrigin() + ";" + flight.getDestination()))
                .entrySet()
                .stream()
                .map(FlightSummary::mapToSummary)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


       List<String> fileFlights2 =  structuredFlights.entrySet().stream()
               .map(entry ->entry.getValue().objectToCsv())
               .collect(Collectors.toList());
//        rigin;destination;shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price
       fileFlights2.add(0, "Origin;Destination;Shortest Flight;Longest Flight;Cheapest Flight;Most Expensive Flight;Average Time;Average Price");
       fileManager.writeLines("Files/FlightsSummary.csv", fileFlights2);


    }


}
