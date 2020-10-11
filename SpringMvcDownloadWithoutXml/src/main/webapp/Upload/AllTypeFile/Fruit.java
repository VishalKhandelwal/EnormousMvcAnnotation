package com.vk;
import java.util.Objects;

public class Fruit {
	
	private String name;
	 private int qty;
	    
   /**
    * @param name
    * @param qty
    */
   public Fruit(String name, int qty) {
       this.name = name;
       this.qty = qty;
   }

   /**
    * method to get quantity
    * @return qty
    */
   public int getQty() {
       return qty;
   }

   /**
    * @param qty
    */
   public void setQty(int qty) {
       this.qty = qty;
   }

   /**
    * @return name
    */
   public String getName() {
       return name;
   }

   /**
    * @param name
    */
   public void setName(String name) {
       this.name = name;
   }

   //Test equal, override equals() and hashCode()
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Fruit fruit = (Fruit) o;
       return qty == fruit.qty &&
               Objects.equals(name, fruit.name);
   }

   @Override
   public int hashCode() {
       return Objects.hash(name, qty);
   }
}
