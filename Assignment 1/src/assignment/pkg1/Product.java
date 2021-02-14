/*
 * Author: Franco Canales
 * Assignment #1
 * Product.java
 */
package assignment.pkg1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product
{
  Manufacturer manufacture;
  String productName;
  int quantity;
  double unitPrice;
  Date productCreated;
  SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
 
  public Product()
  {
      this.productName = "";
      this.quantity = 0;
      this.unitPrice = 0.0;
      this.productCreated = null;
      this.manufacture = null;
  }

 

  public Product(String prodName, int quantity, double unitPrice,
                        Date productCreated, Manufacturer manufact)
  {
      this.productName = prodName;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
      this.productCreated = productCreated;
      this.manufacture = manufact;
  }
  
  public Date getProductCreated()
  {
      return productCreated;
  }
  
  public void setProductCreated(Date productCreated)
  {
      this.productCreated = productCreated;
  }

  public Manufacturer getManufacture()
  {
      return manufacture;
  }
  
  public void setManufacture(Manufacturer manufacture)
  {
      this.manufacture = manufacture;
  }
  
  public String getProductName()
  {
      return productName;
  }

  public void setProductName(String prodName)
  {
      this.productName = prodName;
  }

  public int getQuantity()
  {
      return quantity;
  }

  public void setQuantity(int quantity)
  {
      this.quantity = quantity;
  }

  public double getUnitPrice()
  {
      return unitPrice;
  }

  public void setUnitPrice(double unitPrice)
  {
      this.unitPrice = unitPrice;
  }

  public void upDateQuantity(int quantity_upDate)
  {
      quantity += quantity_upDate;
  }

  public void upDatePrice(double price_upDate)
  {
      this.unitPrice = price_upDate;
  }

  public String getProductInfomation()
  {
      String result = "";
      result += String.format("%-30s", productName);
      String dateForm = sdf.format(productCreated);
      result += String.format("\t %s", dateForm);
      result += String.format("%10d", quantity);
      result += String.format("\t%15.2f", unitPrice);
      result += String.format("\t%15s", manufacture.getCompanyName());
      result += String.format("\t%20s", manufacture.getCompanyAddress().getState());
      return result;
  }  
}
