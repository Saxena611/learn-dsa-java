package morganstanley;

public class FurnitureFactory {


    public static void main(String[] args) {
        FurnitureOrder furnitureOrder = new FurnitureOrder();

        furnitureOrder.addOrderFor(Furniture.CHAIR, 4);
        furnitureOrder.addOrderFor(Furniture.CHAIR, 4);
        furnitureOrder.calculateCostOfOrder();
        furnitureOrder.getOrderCostForType(Furniture.CHAIR);
    }
}
