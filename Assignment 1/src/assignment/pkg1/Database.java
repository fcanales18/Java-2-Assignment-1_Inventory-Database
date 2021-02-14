/*
 * Author: Franco Canales
 * Assignment #1
 * Database.java
 */
package assignment.pkg1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Database
{
   private ArrayList<Product> list;
   private Product prodt;
   private int index;
   private boolean found;

   public Database()
   {
       list = new ArrayList<Product>();
       prodt = null;
       index = 0;
       found = false;
   }

   public void search(String key)
   {
       found = false;
       int i = 0;

       while (!found && i < list.size())
       {
           Product p = list.get(i);
           if (p.getProductName().equalsIgnoreCase(key))
           {
               prodt = p;
               found = true;
               index = i;
           }
           else
               i++;
       }
   }

   public void add(Product newProduct)
   {
       list.add(newProduct);
   }
   public Product delete(int i)
   {
       return list.remove(i);
   }
   public int getIndex()
   {
       return index;
   }
   public boolean inList()
   {
       return found;
   }
   public Product getProduct()
   {
       return prodt;
   }
   public int size()
   {
       return list.size();
   }
   public boolean isEmpty()
   {
       return list.isEmpty();
   }
   public ArrayList<Product> getList()
   {
       return list;
   }
   static SimpleDateFormat dateSDFformat = new SimpleDateFormat("MM/dd/yyyy");
   
   public static String getFormatedProductInfo(Product info)
   {
       String result = String.format("%30s", info.getProductName());
       result += String.format("%30s", dateSDFformat.format(info.getProductCreated()));
       result += String.format("%30s", info.getManufacture().getCompanyName());
       return result;
   }
   
   public void displayDeletedInventory(Database productDB, int Type_Message)
   {
       String inventResult = "";
       ArrayList<Product> prodList = productDB.getList();
       inventResult += String.format("%30s %30s %30s", "Product", 
               "Purchase Date", "Manufacturer");
       for (int i = 0; i < productDB.size(); i++)
       {
           inventResult += getFormatedProductInfo(prodList.get(i)) + "\n";
       }
       JTextArea text = new JTextArea(inventResult, 10, 50);

       JScrollPane pane = new JScrollPane(text);

       JOptionPane.showMessageDialog(null, pane, "Deleted Inventory Details", 
               Type_Message);
   }
   
   public void displayInventory(Database productDB, int Type_Message)
   {
       String inventResult = "";
       ArrayList<Product> prodList = productDB.getList();
       inventResult += String.format("%-30s \t%s %10s %15s %20s %15s\n", 
               "Product", "Purchase Date", "Quantity",
               "Price($)", "Manufacturer", "State");
       for (int i = 0; i < productDB.size(); i++)
       {
           inventResult += prodList.get(i).getProductInfomation() + "\n";
       }
       JTextArea text = new JTextArea(inventResult, 10, 60);

       JScrollPane pane = new JScrollPane(text);

       JOptionPane.showMessageDialog(null, pane, "Inventory Details", 
               Type_Message);
   }

   public void displaySingleProduct(Product product, int Type_Message)
   {
       String productInfo = "Product Name: " + product.getProductName() + "\n";
       productInfo += String.format("Product's Unit Price: $%.2f", 
               product.getUnitPrice()) + "\n";
       productInfo += "Quantity of product: " + product.getQuantity() + "\n";
       JTextArea text = new JTextArea(productInfo, 10, 30);

       JScrollPane pane = new JScrollPane(text);

       JOptionPane.showMessageDialog(null, pane, product.getProductName() + 
               " Details", Type_Message);
   }
}