public class Groceries {
 Products[] products = new Products[10];
  private int spaceAvailable = products.length;

  public void addProduct(Products product) {
         if (spaceAvailable <= 0) {
             System.out.printf("Немає вільного місця ");
             return;
         }

          for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {

            }
            System.out.println("Продукт &s додано успішно".formatted(product.getName()));
          }
  }
}
