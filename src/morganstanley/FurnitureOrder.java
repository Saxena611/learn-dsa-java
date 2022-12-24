package morganstanley;

import java.util.EnumMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureInterface {

    private Map<Furniture, Integer> fOrder;

    FurnitureOrder() {
        fOrder = new EnumMap<>(Furniture.class);
    }


    @Override
    public void addOrderFor(Furniture furniture, Integer quantity) {
        fOrder.computeIfAbsent(furniture, s -> 0);
        fOrder.compute(furniture, (k,v) -> Integer.sum(v, quantity));
    }

    @Override
    public float calculateCostOfOrder() {
        float totalCost = 0.0f;
        for(Map.Entry<Furniture, Integer> entry: fOrder.entrySet()) {
            float itemCost = entry.getKey().getCost();
            float currItemCost = itemCost* entry.getValue();
            totalCost += currItemCost;
        }
        return totalCost;
    }

    @Override
    public float getOrderCostForType(Furniture type) {
        return fOrder.get(type)*type.getCost();
    }
}
