package ru.netology;

import java.util.Comparator;

public class TicketByDurationDescComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o2.getDuration() - o1.getDuration();
    }
}
