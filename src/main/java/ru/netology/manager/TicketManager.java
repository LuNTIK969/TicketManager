package ru.netology.manager;

import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repo;

    protected TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }

}
