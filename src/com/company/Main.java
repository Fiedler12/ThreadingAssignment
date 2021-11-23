package com.company;

class CustomerThread extends Thread {
    private Thread thread;
    private String name;
    Ticket ticket;
    CustomerThread (String name, Ticket ticket) {
        this.name = name;
        this.ticket = ticket;
    }
    public void run() {
        synchronized (ticket) {
            if (ticket.owned == false) {
                ticket.owned = true;
                System.out.println(name + " has purchased the ticked with ID: " + ticket.id);
            }
            else {
                System.out.println(name + " cannot purchase this ticket as it is already owned.");
            }
            System.out.println("Transaction for " + name + " has concluded");
        }
    }

    public void start() {
        System.out.println("The tread" + name + "is queuing up to buy a ticket");
        if (thread == null) {
            thread = new Thread(this, name);
        }
    }
}

class Ticket {
    int id;
    boolean owned = false;
}

public class Main {
    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[5];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = new Ticket();
            tickets[i].id = i;
        }

        CustomerThread c1 = new CustomerThread("c1", tickets[0]);
        CustomerThread c2 = new CustomerThread("c2", tickets[1]);
        CustomerThread c3 = new CustomerThread("c3", tickets[1]);
        CustomerThread c4 = new CustomerThread("c4", tickets[1]);
        CustomerThread c5 = new CustomerThread("c5", tickets[2]);
        CustomerThread c6 = new CustomerThread("c6", tickets[4]);
        CustomerThread c7 = new CustomerThread("c7", tickets[3]);
        CustomerThread c8 = new CustomerThread("c8", tickets[3]);
        CustomerThread c9 = new CustomerThread("c9", tickets[4]);
        CustomerThread c10 = new CustomerThread("c10", tickets[4]);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();

        try {
            c1.run();
            c2.run();
            c3.run();
            c4.run();
            c5.run();
            c6.run();
            c7.run();
            c8.run();
            c9.run();
            c10.run();
        }
        catch (Exception e) {
            System.out.println("error");
        }
    }
}
