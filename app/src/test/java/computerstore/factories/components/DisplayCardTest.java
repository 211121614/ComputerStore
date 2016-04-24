package computerstore.factories.components;

import org.junit.Test;
import com.computerstore.factories.components.DisplayCardFactory;
import com.computerstore.domain.components.DisplayCard;
import junit.framework.Assert;
/**
 * Created by Aidem on 2016/04/17.
 */

public class DisplayCardTest {

    private DisplayCardFactory factory;

    @Test
    public void testDisplayCardCreation() throws Exception {
        DisplayCard displayCard = factory.createDisplayCard("210-1GD3-L",50,"GeForce GTX 210",499.00);
        Assert.assertEquals(displayCard.getDescription(),"GeForce GTX 210");
        Assert.assertEquals(displayCard.getProductNumber(),"210-1GD3-L");
        Assert.assertNotNull(displayCard.getId());
    }

    @Test
    public void testDisplayCardUpdate() throws Exception {
        DisplayCard displayCard = factory.createDisplayCard("210-1GD3-L",50,"GeForce GTX 210",499.00);
        Assert.assertEquals(displayCard.getDescription(),"GeForce GTX 210");
        Assert.assertEquals(displayCard.getProductNumber(),"210-1GD3-L");
        Assert.assertNotNull(displayCard.getId());

        // Updated Description

        DisplayCard updateDisplayCard = new DisplayCard.Builder()
                .DisplayCard(displayCard)
                .price(699.00)
                .build();

        Assert.assertEquals(updateDisplayCard.getPrice(),699.00);
        Assert.assertEquals(displayCard.getProductNumber(),updateDisplayCard.getProductNumber());
        Assert.assertEquals(displayCard.getId(),updateDisplayCard.getId());




    }
}
