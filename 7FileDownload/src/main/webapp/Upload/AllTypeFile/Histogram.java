public class Histogram {  
 
  public static void main(String[] args) { 
 
    int array[] = {4,10,7,15,12,3,7,10,6,19};
 
    String output = "Element\tValue\tHistogram";
 
    for ( int counter = 0; counter < array.length; counter++ ) {
      output += "\n" + counter + "\t" + array[ counter ] + "\t";
 
      for ( int stars = 0; stars < array[ counter ]; stars++ ) {
        output += "*";   
      }
    }
    System.out.println(output);
  } 
} 