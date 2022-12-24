package morganstanley;

interface FurnitureInterface {

     void addOrderFor(Furniture furniture, Integer quantity);
     float calculateCostOfOrder();
     float getOrderCostForType(Furniture furniture);
}
