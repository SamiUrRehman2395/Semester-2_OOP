class Category{
    private String categoryName;
    private int categoryId;

    public Category(String categoryName, int categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        Category that = (Category) o;

        return this.categoryId==that.categoryId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}

class Product{
    private String productName;
    private int productId;
    private Category category;

    public Product(String productName, int productId, Category category) {
        this.productName = productName;
        this.productId = productId;
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        Product that = (Product) obj;

        return this.productId==that.productId && this.category.equals(that.category);

    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", category=" + category +
                '}';
    }
}


public class Demo2 {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 501, new Category("Electronics", 1));

        Product p2 = new Product("Laptop Pro", 501, new Category("Electronics", 1));

        Product p3 = new Product("Smartphone", 502, new Category("Mobile Device", 2));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


    }
}
