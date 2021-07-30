package be.kuleuven.ses.factory;

import be.kuleuven.ses.factory.tickets.AdultRatedTicket;
import be.kuleuven.ses.factory.tickets.FamilyTicket;
import be.kuleuven.ses.factory.tickets.TeenageTicket;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AgeBasedTicketSellerTest {

    private AgeBasedTicketSeller seller;
    private final Person kid = new Person(8);
    private final Person youngster = new Person(14);
    private final Person grownUp = new Person(22);

    @BeforeEach
    public void setUp() {
        this.seller = new AgeBasedTicketSeller();
    }

    @Test
    public void buyTicket_AsAKid_GetsAFamilyTicket() {
        var ticket = seller.buyTicketFor(kid);
        assertThat(ticket, Matchers.instanceOf(FamilyTicket.class));
    }

    @Test
    public void buyTicket_AsAYoungster_GetsTeenageTicket() {
        var ticket = seller.buyTicketFor(youngster);
        assertThat(ticket, Matchers.instanceOf(TeenageTicket.class));
    }

    @Test
    public void buyTicket_AsAGrownUp_GetsTheRealDeal() {
        var ticket = seller.buyTicketFor(grownUp);
        assertThat(ticket, Matchers.instanceOf(AdultRatedTicket.class));
    }
}
