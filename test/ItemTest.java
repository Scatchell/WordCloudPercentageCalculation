import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 1/4/12
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class ItemTest {
    @Test
    public void ShouldCalculatePercentage() {
        Item item = new Item("Test", 20);

        item.calcPercentage(40);

        assertEquals(50, item.getPercentage());
    }

    @Test
    public void ShouldSortListOfItems() {
        ArrayList<Item> itemList = new ArrayList<Item>();

        itemList.add(new Item("Test1", 20));
        itemList.add(new Item("Test2", 10));
        itemList.add(new Item("Test3", 30));

        ArrayList<Item> sortedItemList = new ArrayList<Item>();

        sortedItemList.add(new Item("Test3", 30));
        sortedItemList.add(new Item("Test1", 20));
        sortedItemList.add(new Item("Test2", 10));

        Collections.sort(itemList, new HitsComparator());


        assertEquals(sortedItemList, itemList);
    }
}
