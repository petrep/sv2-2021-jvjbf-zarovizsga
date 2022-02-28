package shipping;

public interface Transportable {
    abstract int getWeight();
    abstract boolean isBreakable();
    abstract int calculateShippingPrice();

    default String getDestinationCountry() {
        return "Hungary";
    }

}
