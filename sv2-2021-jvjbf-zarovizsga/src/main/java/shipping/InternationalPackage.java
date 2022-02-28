package shipping;

public class InternationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    private final int SHIPPING_PRICE = 1200;
    private final int KM_PRICE = 10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int calculateShippingPrice() {
        int price = breakable ? 2 * SHIPPING_PRICE : SHIPPING_PRICE;
        price += distance * KM_PRICE;
        return price;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
