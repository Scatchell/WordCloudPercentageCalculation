import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 1/4/12
 * Time: 12:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class HitsComparator implements Comparator {
    @Override
    public int compare(Object o, Object o1) {
        Item a = (Item) o;
        Item b = (Item) o1;

        if(b.getHits() > a.getHits()) {
            return 1;
        } else if(a.getHits() == b.getHits()) {
            return 0;
        } else {
            return -1;
        }
    }
}
