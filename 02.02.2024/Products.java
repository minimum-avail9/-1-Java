public class Products {
    private double cost;
    private String name;
    private double weight;

    public Products(double cost, String name, double weight) {
        this.cost = cost;
        this.name = name;
        this.weight = weight;


    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
