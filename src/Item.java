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

        this.percentage = (int) dPercentage;
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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (hits != item.hits) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + hits;
        result = 31 * result + percentage;
        return result;
    }
}
