package morganstanley;

public enum Furniture {

    CHAIR("Chair", 200.0f),
    TABLE("Table", 100.0f),
    COUCH("Couch", 300.0f);

    String label;
    float cost;

    Furniture(String label, float cost) {
        this.label = label;
        this.cost = cost;
    }

    public String getLabel() {
        return label;
    }

    public float getCost() {
        return cost;
    }
}
