/*
 * author: Franco Canales
 * Assignment #1
 * Address.java
 */
package assignment.pkg1;

public class Address
{
  private String city, state;
  
  public Address (String city, String st)
  {
      this.city = city;
      state = st;
  }
  
  public String getCity() {
      return city;
  }
  
  public String getState() {
      return state;
  }
}
