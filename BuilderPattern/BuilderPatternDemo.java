public class BuilderPatternDemo {

    public static class CafeOrder {
        private String coffeeType;
        private String milkType;
        private String sugar;
        private String size;

        public CafeOrder(String coffeeType, String milkType, String sugar, String size) {
            this.coffeeType = coffeeType;
            this.milkType = milkType;
            this.sugar = sugar;
            this.size = size;
        }

        @Override
        public String toString() {
            return "CafeOrder [Coffee Type: " + coffeeType + ", Milk Type: " + milkType + 
                    ", Sugar: " + sugar + ", Size: " + size + "]";
        }
    }

    public static class CafeOrderBuilder {
        private String coffeeType;
        private String milkType;
        private String sugar;
        private String size;

        public CafeOrderBuilder setCoffeeType(String coffeeType) {
            this.coffeeType = coffeeType;
            return this;
        }

        public CafeOrderBuilder setMilkType(String milkType) {
            this.milkType = milkType;
            return this;
        }

        public CafeOrderBuilder setSugar(String sugar) {
            this.sugar = sugar;
            return this;
        }

        public CafeOrderBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public CafeOrder build() {
            return new CafeOrder(coffeeType, milkType, sugar, size);
        }
    }

   
    public static void main(String[] args) {

        CafeOrderBuilder orderBuilder = new CafeOrderBuilder();
        CafeOrder order1 = orderBuilder
                .setCoffeeType("Latte")
                .setMilkType("Almond Milk")
                .setSugar("2 cubes")
                .setSize("Large")
                .build();

        
        System.out.println(order1);

        CafeOrder order2 = orderBuilder
                .setCoffeeType("Espresso")
                .setMilkType("Whole Milk")
                .setSugar("No sugar")
                .setSize("Medium")
                .build();

        System.out.println(order2);
    }
}

