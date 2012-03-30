import java.util.Comparator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 30/3/12
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValueComparator implements Comparator {

    Map base;
    public ValueComparator(Map base) {
        this.base = base;
    }

    public int compare(Object a, Object b) {

        if((Integer)base.get(a) < (Integer)base.get(b)) {
            return 1;
        } else if(base.get(a) == base.get(b)) {
            return 0;
        } else {
            return -1;
        }
    }
}
