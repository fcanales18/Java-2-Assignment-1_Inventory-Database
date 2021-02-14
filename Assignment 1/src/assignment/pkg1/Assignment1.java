/*
 * Author: Franco Canales
 * Assignment #1
 * Assignment.java
 */
package assignment.pkg1;

import java.util.Date;
import javax.swing.JOptionPane;
import java.text.*;

public class Assignment1
{
   static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

   public static void main(String args[]) throws ParseException
   { 
       String city; 
       String state;
       String manufacturerName;
       String productName;
       int quantity;
       String dateMenu;
       double unitPrice;
       Product product = new Product();
       Manufacturer manufacture = new Manufacturer();
       Address address = null;
       Database productDB = new Database();
       Database deletedProdDB = new Database();
       Date present = new Date();
       boolean isDone = false;
       int subDirectory = 0;

       while (!isDone)
       {
           int selectedMenu = GetData.getInt("Product Inventory Directory\n\t1. "
                   + "To Enter a New Product\n"
                   + "\t2. To Update Product\n\t3. To Delete a Product\n"
                   + "\t4. Product Report \n\t5. Inventory Report\n"
                   + "\t6. Report of deleted Products\n\t7. End Session");

           switch (selectedMenu)
           {
           case 1:

               productName = GetData.getString("Please enter product name: ");
               quantity = GetData.getInt("How many?: ");
               unitPrice = GetData.getDouble("Please enter the unit price: ");
               manufacturerName = GetData.getString("Manufacturer Name?: ");
               city = GetData.getString("Please enter the city of Manufacturer: ");
               state = GetData.getString("Please enter state name of Manufacturer: ");
               dateMenu = GetData.getString("Enter purchase date (mm/dd/yyyy): ");
               address = new Address(city, state);
               manufacture = new Manufacturer(manufacturerName, address);
               present = sdf.parse(dateMenu);
               product = new Product(productName, quantity, unitPrice, present, 
                       manufacture);
               productDB.add(product);
               break;

           case 2:
               productName = GetData.getString("What product are you trying to "
                       + "update?: ");
               subDirectory = GetData.getInt("Select option to update: \n1. "
                       + "To update quantity\n2. To update price\n");
               productDB.search(productName);
               if (!productDB.inList())
               {
                   JOptionPane.showMessageDialog(null, "Product not found.");
               }
               else
               {
                   switch (subDirectory)
                   {
                   case 1:

                       int menuOpt = GetData.getInt(
                               "Select option to update: \n1. To add "
                                       + "quantity\n2. To remove quantity\n");
                       int addRDeductQuant = 0;

                       if (menuOpt < 1 || menuOpt > 2)
                       {
                           JOptionPane.showMessageDialog(null, "Please, only one"
                                   + " of the two choices!");
                       }
                       else
                       {
                           switch (menuOpt)
                           {
                           case 1:

                               addRDeductQuant = GetData.getInt("Please enter "
                                       + "the amount of quantity to add: ");
                               product = productDB.getProduct();
                               product.upDateQuantity(addRDeductQuant);
                               break;
                           case 2:
                               addRDeductQuant = GetData.getInt("Please enter "
                                       + "the amount of quantity to deduct: ");
                               product = productDB.getProduct();
                               product.upDateQuantity(addRDeductQuant * -1);
                               break;
                           }
                           JOptionPane.showMessageDialog(null,
                                   "Updated Successfully!");
                       }
                       break;
                       
                   case 2:

                       double priceToUpdate = GetData.getDouble("Please enter "
                               + "updated unit price: ");

                       if (priceToUpdate < 0)
                       {
                           JOptionPane.showMessageDialog(null, "Error. Please "
                                   + "choose a positive number.");
                       }
                       else
                       {
                           product = productDB.getProduct();
                           product.upDatePrice(priceToUpdate);
                           JOptionPane.showMessageDialog(null, "Updated "
                                   + "successfully!");
                       }
                       break;
                   default:
                       JOptionPane.showMessageDialog(null,
                               "Error. Please read the instructions carefully.");
                   }
               }
               break;

           case 3:

               productName = GetData.getString("What product are you trying to "
                       + "update?: ");
               productDB.search(productName);
               
               if (productDB.inList())
               {
                   int index = productDB.getIndex();
                   deletedProdDB.add(productDB.getProduct());
                   productDB.delete(index);
                   JOptionPane.showMessageDialog(null,
                           productName +  " was deleted successfully.");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Product not found. "
                           + "Please enter a valid product name.");
               }
               break;

           case 4:

               productName = GetData.getString("Please enter name of the "
                       + "product: ");
               productDB.search(productName);

               if (productDB.inList())
               {
                   productDB.displaySingleProduct(productDB.getProduct(), 
                           JOptionPane.INFORMATION_MESSAGE);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Product not found. "
                           + "Please try again.");
               }
               break;

           case 5:
               
               if (productDB.getList() != null)
               {
                   productDB.displayInventory(productDB, 
                           JOptionPane.INFORMATION_MESSAGE);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Error! There are no "
                           + "such product currently in the inventory!.");
               }
               break;
               
           case 6:
               
               if (deletedProdDB.getList() != null)
               {
                   productDB.displayInventory(deletedProdDB, 
                           JOptionPane.INFORMATION_MESSAGE);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Error. No products "
                           + "currently in database..");
               }
               break;

           case 7:
               
               isDone = true;
               break;

           default:
               JOptionPane.showMessageDialog(null, "Error! Please enter a "
                       + "valid option.");
           }
       }
   }
}
