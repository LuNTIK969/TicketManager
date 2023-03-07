package ru.netology;

import java.io.Serializable;
import java.util.Comparator;

public class TicketByDurationDescComparator implements Comparator<Ticket>, Serializable {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o2.getDuration() - o1.getDuration();
    }
}
