public class Stock {
    String symbol;
    String name;
    double closingPrice;

    public Stock(String symbol, String name, double closingPrice) {
        this.symbol = symbol;
        this.name = name;
        this.closingPrice = closingPrice;
    }

    @Override
    public String toString() {
        return String.format("%-6s %s (%1.2f",symbol,name, closingPrice);
    }
}
