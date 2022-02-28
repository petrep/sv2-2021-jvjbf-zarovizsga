package shipping;

public class NationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private final int SHIPPING_PRICE = 1000;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        return breakable ? 2 *SHIPPING_PRICE : SHIPPING_PRICE;
    }

    @Override
    public String getDestinationCountry() {
        return Transportable.super.getDestinationCountry();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }
}
