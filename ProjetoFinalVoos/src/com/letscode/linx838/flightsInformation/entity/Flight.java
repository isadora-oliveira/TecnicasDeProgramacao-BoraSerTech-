package com.letscode.linx838.flightsInformation.entity;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Flight {
   private String origin;
   private String destination;
   private String airline;
   private OffsetDateTime departure;
   private OffsetDateTime arrival;
   private Double price;
   private long duration;



    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return this.airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public OffsetDateTime getDeparture() {
        return this.departure;
    }
    public void setDeparture(OffsetDateTime departure) {
        this.departure = departure;
    }

    public OffsetDateTime getArrival() {
        return this.arrival;
    }
    public void setArrival(OffsetDateTime arrival) {
        this.arrival = arrival;
    }

    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDuration(long duration) { this.duration = duration; }
    public long getDuration() {
        //Utilizando o método until() para calcular o tempo de vôo
        this.duration= getDeparture().until(getArrival(), ChronoUnit.HOURS);
        return this.duration;
    }

    public Flight(String origin, String destination, String airline, OffsetDateTime departure, OffsetDateTime arrival, Double price) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public Flight(String origin, String destination, String airline, OffsetDateTime departure, OffsetDateTime arrival, Double price, long duration) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.duration = duration;

    }

    public Flight() {
    }

    public static Flight stringToFlightObject(String line) {

        String[] informations = line.split(";");

        //Criado DateTimeFormatter personalizado para converter a data disponibilizada no .csv em OffsetDateTime.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (XXX)");

        // Criando o flightObject e associando os índices do array conforme construtor.
        Flight flightObject = new Flight(informations[0],informations[1],informations[2], OffsetDateTime.parse(informations[3], formatter),
                OffsetDateTime.parse(informations[4], formatter), Double.valueOf(informations[5]) );
        return flightObject;
    }
    //criando o padrão para geração do arquivo .csv
    public String objectToCsv(){

        return origin + ";" + destination + ";" + airline + ";" + departure + ";" + arrival + ";" + "R$ " + price +  ";"
                + duration + " hours";

    }




    @Override
    public String toString() {
        return "Flight{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}