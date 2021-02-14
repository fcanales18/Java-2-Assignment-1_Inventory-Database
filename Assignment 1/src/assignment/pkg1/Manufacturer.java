/*
 * Author: Franco Canales
 * Assignment #1
 * Manufacturer.java
 */
package assignment.pkg1;

public class Manufacturer
{
  private String companyName;
  private Address companyAddress;

  public Manufacturer()
  {
      this.companyName = "";
      this.companyAddress = null;
  }

  public Manufacturer(String compName, Address address)
  {
      this.companyName = compName;
      this.companyAddress = address;
  }

  public String getCompanyName()
  {
      return companyName;
  }
  
  public void setCompanyName(String companyName)
  {
      this.companyName = companyName;
  }
  
  public Address getCompanyAddress()
  {
      return companyAddress;
  }
  
  public void setCompanyAddress(Address address)
  {
      this.companyAddress = address;
  }
}
