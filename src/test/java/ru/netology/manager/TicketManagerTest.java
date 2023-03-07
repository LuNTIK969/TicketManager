package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.TicketByDurationDescComparator;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticketOne = new Ticket(1, 2_345, "VOZ", "GUW", 231);
    Ticket ticketTwo = new Ticket(2, 34_634, "YKS", "MJZ", 222);
    Ticket ticketThree = new Ticket(3, 21_123, "VOZ", "GUW", 122);
    Ticket ticketFour = new Ticket(4, 2_352, "VOZ", "GUW", 234);
    Ticket ticketFive = new Ticket(5, 1_111, "GUW", "VOZ", 222);
    Ticket ticketSix = new Ticket(6, 23_521, "GRV", "MJZ", 222);
    Ticket ticketSeven = new Ticket(7, 12_543, "VOZ", "GUW", 212);
    Ticket ticketEight = new Ticket(8, 24_353, "GUW", "GRV", 453);
    Ticket ticketNine = new Ticket(9, 1_111, "VOZ", "GUW", 231);
    Ticket ticketTen = new Ticket(10, 1_111, "GUW", "SQQ", 235);
    Ticket ticketEleven = new Ticket(11, 11_111, "GRV", "SQQ", 202);

    @BeforeEach
    public void shouldAddAll() {
        manager.add(ticketOne);
        manager.add(ticketTwo);
        manager.add(ticketThree);
        manager.add(ticketFour);
        manager.add(ticketFive);
        manager.add(ticketSix);
        manager.add(ticketSeven);
        manager.add(ticketEight);
        manager.add(ticketNine);
        manager.add(ticketTen);
    }

    @Test
    public void shouldShowAllComparator() {
        Comparator<Ticket> comparator = new TicketByDurationDescComparator();

        Ticket[] expected = new Ticket[]{ticketFour, ticketOne, ticketNine, ticketSeven, ticketThree};
        assertArrayEquals(expected, manager.findAll("VOZ", "GUW", comparator));
    }

    @Test
    public void shouldShowAll() {
        Ticket[] expected = new Ticket[]{ticketNine, ticketOne, ticketFour, ticketSeven, ticketThree};
        assertArrayEquals(expected, manager.findAll("VOZ", "GUW"));
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(7);
        repo.removeById(4);

        Ticket[] expected = new Ticket[]{ticketOne, ticketTwo, ticketThree, ticketFive, ticketSix, ticketEight, ticketNine, ticketTen};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldNotFind() {
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(expected, manager.findAll("CEK", "UUS"));
    }

    @Test
    public void shouldFindOne() {
        Ticket[] expected = new Ticket[]{ticketTwo};
        assertArrayEquals(expected, manager.findAll("YKS", "MJZ"));
    }

    @Test
    public void shouldAddNew() {
        manager.add(ticketEleven);

        Ticket[] expected = new Ticket[]{ticketOne, ticketTwo, ticketThree, ticketFour, ticketFive, ticketSix, ticketSeven, ticketEight, ticketNine, ticketTen, ticketEleven};
        assertArrayEquals(expected, repo.findAll());
    }

}