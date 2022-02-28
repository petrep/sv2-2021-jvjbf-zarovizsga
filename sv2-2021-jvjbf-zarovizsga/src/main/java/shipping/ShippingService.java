package shipping;

import java.util.*;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public List<Transportable> getPackages() {
        return List.copyOf(packages);
    }

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        List<Transportable> filteredPackages = new ArrayList<>();

        for (Transportable actualPackage : packages) {

            if ((actualPackage.isBreakable()==breakable && (actualPackage.getWeight() >= weight))) {
                filteredPackages.add(actualPackage);
            }
        }

        return filteredPackages;
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> transportablesByCountry = new HashMap<>();
        for (Transportable actual : packages) {
            if (transportablesByCountry.containsKey(actual.getDestinationCountry())) {
                transportablesByCountry.put(actual.getDestinationCountry(), transportablesByCountry.get(actual.getDestinationCountry()) + 1);
            } else {
                transportablesByCountry.put(actual.getDestinationCountry(), 1);
            }
        }
        return transportablesByCountry;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(transportable -> transportable instanceof InternationalPackage)
                .sorted(Comparator.comparing(p -> ((InternationalPackage) p).getDistance()))
                .toList();
    }
}
