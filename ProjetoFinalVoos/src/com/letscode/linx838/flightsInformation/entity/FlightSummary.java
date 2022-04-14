package com.letscode.linx838.flightsInformation.entity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightSummary {
//        shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price
    private String originDestination;
    private Long shortest;
    private Long longest;
    private Double cheapest;
    private Double mostExpensive;
    private Double avarageTime;
    private Double avaragePrice;
    private List<Flight> flights;


    public FlightSummary(String originDestination, Long shortest, Long longest, Double cheapest, Double mostExpensive,
                         Double avarageTime, Double avaragePrice) {
        this.originDestination = originDestination;
        this.shortest = shortest;
        this.longest = longest;
        this.cheapest = cheapest;
        this.mostExpensive = mostExpensive;
        this.avarageTime = avarageTime;
        this.avaragePrice = avaragePrice;

    }

    public String getOriginDestination() {
        return originDestination;
    }

    public void setOriginDestination(String originDestination) {
        this.originDestination = originDestination;
    }

    public Long getShortest() {
        return shortest;
    }

    public void setShortest(Long shortest) {
        this.shortest = shortest;
    }

    public Long getLongest() {
        return longest;
    }

    public void setLongest(Long longest) {
        this.longest = longest;
    }

    public Double getCheapest() {
        return cheapest;
    }

    public void setCheapest(Double cheapest) {
        this.cheapest = cheapest;
    }

    public Double getMostExpensive() {
        return mostExpensive;
    }

    public void setMostExpensive(Double mostExpensive) {
        this.mostExpensive = mostExpensive;
    }

    public Double getAvarageTime() {
        return avarageTime;
    }

    public void setAvarageTime(Double avarageTime) {
        this.avarageTime = avarageTime;
    }

    public Double getAvaragePrice() {
        return avaragePrice;
    }

    public void setAvaragePrice(Double avaragePrice) {
        this.avaragePrice = avaragePrice;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    // Configurando as chaves/valores do mapa e realizando a sumarização dos vôos solicitados
    public static Map.Entry<String, FlightSummary> mapToSummary(Map.Entry<String, List<Flight>> entry) {
        String originDestination = entry.getKey();

        List<Flight> flights = entry.getValue();
        Long shortest = flights.stream().mapToLong(Flight::getDuration).min().getAsLong();
        Long longest = flights.stream().mapToLong(Flight::getDuration).max().getAsLong();
        Double cheapest = flights.stream().mapToDouble(Flight::getPrice).min().getAsDouble();
        Double mostExpensive = flights.stream().mapToDouble(Flight::getPrice).max().getAsDouble();
        Double avarageTime = flights.stream().mapToDouble(Flight::getDuration).average().getAsDouble();
        Double avaragePrice = flights.stream().mapToDouble(Flight::getPrice).average().getAsDouble();


        return Map.entry(originDestination, new FlightSummary(originDestination, shortest, longest, cheapest,
                mostExpensive, avarageTime,  avaragePrice));
    }

    //criando o padrão para geração do arquivo .csv
    // originDestination sendo dividido por ";" na coleta dos dados (FlightsApplication - line 43)
    public String objectToCsv(){

        return originDestination + ";" + shortest + " hours" + ";" + longest +  " hours" + ";" +
                 "R$ " + cheapest + ";" + "R$ " + mostExpensive + ";" + avarageTime + " hours" + ";"  + "R$ " + avaragePrice;
    }


    @Override
    public String toString() {
        return "FlightSummary{" +

                "Origin;Destination:" + originDestination + '\'' +
                ", shortest=" + shortest +
                ", longest=" + longest +
                ", cheapest=" + cheapest +
                ", mostExpensive=" + mostExpensive +
                ", avarageTime=" + avarageTime +
                ", avaragePrice=" + avaragePrice +
                '}';
    }
}

