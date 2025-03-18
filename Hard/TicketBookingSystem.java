package Hard;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBooking implements Runnable {
    private static int availableTickets = 5;
    private static final Lock lock = new ReentrantLock();
    private String userType;

    public TicketBooking(String userType) {
        this.userType = userType;
    }

    public void run() {
        try {
            lock.lock();
            if (availableTickets > 0) {
                System.out.println(userType + " booked a ticket. Remaining: " + --availableTickets);
            } else {
                System.out.println(userType + " booking failed! No tickets available.");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        Thread vip1 = new Thread(new TicketBooking("VIP User"));
        Thread vip2 = new Thread(new TicketBooking("VIP User"));
        Thread reg1 = new Thread(new TicketBooking("Regular User"));
        Thread reg2 = new Thread(new TicketBooking("Regular User"));
        Thread reg3 = new Thread(new TicketBooking("Regular User"));

        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        reg1.setPriority(Thread.MIN_PRIORITY);
        reg2.setPriority(Thread.MIN_PRIORITY);
        reg3.setPriority(Thread.MIN_PRIORITY);

        vip1.start();
        vip2.start();
        reg1.start();
        reg2.start();
        reg3.start();
    }
}
