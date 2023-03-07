package ru.netology;

import lombok.*;

import java.util.Objects;

@Getter
@Setter

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int duration;

    public Ticket(int id, int price, String from, String to, int duration) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && duration == ticket.duration && Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, duration);
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }

}