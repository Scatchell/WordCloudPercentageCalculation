/**
 * Created by IntelliJ IDEA.
 * User: anthony
 * Date: 1/4/12
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    String name;

    int hits;
    int percentage;
    public Item(String name, int hits) {
        this.name = name;
        this.hits = hits;
    }

    public void calcPercentage(double largest) {
        double dPercentage = (double) hits;
        dPercentage /= largest;
        dPercentage *= 100;

        percentage = (int) dPercentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Item otherItem = (Item) obj;
        return otherItem.getHits() == this.getHits() && otherItem.getName().equals(this.getName());
    }
}
