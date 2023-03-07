package ru.netology.repository;

import ru.netology.Ticket;

public class TicketRepository {
    protected Ticket[] tickets = new Ticket[0];

    public Ticket[] addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
        return tickets.clone();
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int temporaryCopy = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[temporaryCopy] = ticket;
                temporaryCopy++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets == null ? null : tickets.clone();
    }
}
