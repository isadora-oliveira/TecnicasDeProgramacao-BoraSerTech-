package com.letscode.linx838.flightsInformation.tests;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // classe criada para colocar todos os testes realizados até a aplicação correta

//        FileManager fileManager = new FileManager();
//
//        //Testando o funcionamento do método "createFile" do FileManager
//        List<String> flightsTest = fileManager.readLines("flights.csv");
//
//
//        System.out.println(flightsTest);

//        Flight flightsInformation = new Flight();
//        flightsInformation.stringToFlightObject(fileManager.readLines("flights.csv"));


//             String date = "30/04/2022 06:00:00 (-11:00)";
//             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (XXX)");
//             ZonedDateTime correctFormat = ZonedDateTime.parse(date, formatter);
//             System.out.println(correctFormat);

// Teste real para calcular a duração do Vôo:
            String date1 = "15/04/2022 19:00:00 (-01:00)";
            String date2 = "16/04/2022 13:00:00 (-05:00)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (XXX)");

        OffsetDateTime objDate1 = OffsetDateTime.parse(date1,formatter);
        OffsetDateTime objDate2 = OffsetDateTime.parse(date2,formatter);

        OffsetDateTime withOffsetHours1 = objDate1.withOffsetSameInstant(ZoneOffset.ofHours(0));
        OffsetDateTime withOffsetHours2 = objDate2.withOffsetSameInstant(ZoneOffset.ofHours(0));

        long duration = withOffsetHours1.until(withOffsetHours2, ChronoUnit.HOURS);

        System.out.println("Data 1 sem Offset: " +objDate1);
        System.out.println("Data 2 sem Offset: " +objDate2);
        System.out.println("Data 1 sem Offset: " +withOffsetHours1);
        System.out.println("Data 1 sem Offset: " +withOffsetHours2);
        System.out.println("Horas de diferença: " +duration);



//Criando como atributo do objeto voo
//    public void setDuration(long duration) {
//    this.duration= getDeparture().until(getArrival(), ChronoUnit.HOURS);}
//    }
//    public long getDuration() {return this.duration;}
}}

//        List<Flight> structuredFlight = stringToObject.stream()
//                .sorted(Comparator.comparing(Flight::getDuration)
//                .thenComparing(Flight::getPrice)
//                .thenComparing(Flight::getAirline)).collect(Collectors.toList());



//
//
//            return null;
//       }













//MAP


//        Set<Map.Entry<String, List<Flight>>> entrySet = mapFlights.entrySet();
//        List<Map.Entry<String, List<Flight>>> listOfEntry = new ArrayList<Map.Entry<String, List<Flight>>>(entrySet);

//
//        Set<String> keySet = mapFlights.keySet();
//        List<String> listOfKeys = new ArrayList<String>(keySet);
//        Collection<List<Flight>> values = mapFlights.values();
//
////        List<Flight> listOfValues;
////        listOfValues = new ArrayList<String>(values);
//
//        String keys = String.join(";", listOfKeys) + String.valueOf(value);


////        List<String> listOfKeys = new ArrayList<>(flights.keySet());

///
//        List<String> finalFlights = structuredFlights.stream().
////        // Transfomando o mapa em lista de String= structuredFlights.values().stream().
////                sorted(Comparator.comparing(Flight.)
////                .collect(Collectors.toList());
//
////
////
////
//////////        Criando o diretório em que os arquivos .csv serão gerados
////////        fileManager.createDirectory("Files");
////////
//        fileManager.writeLines("Files/StructuredFlights.csv", structuredFlights);
//////
//////        System.out.println(structuredFlights);
//        public static List<String> objectToCsv(List<Flight> flight){
//
//            String[] splittedString = flight.split(";");
//            List<String> finalList = Arrays.stream(splittedString).collect(Collectors.toList());
//            return finalList;
//
//        }

//    List<String> splitteredOriginDestination = Stream.of(originDestination).collect(Collectors.toList());
//    String origin = splitteredOriginDestination.get(0);
//    String destination = splitteredOriginDestination.get(1);
//        shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price
//        List<String> file2 = (List<String>) fileFlights2;
//
//
//
////


//
//        System.out.println(fileFlights2);