import java.util.Comparator;

/**
 * Point.java. 
 * Models a two dimensional point as a Cartesian coordinate (x, y)
 * in Quadrant I (x >= 0 and y >= 0). This class is designed to be
 * immutable.
 *
 * @author  Evan Hodges (ejh0058@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 10/01/2023
 *
 */
public final class Point implements Comparable<Point> {

  /** Compare two points with respect to the slope each makes with this point. */
   public final Comparator<Point> slopeOrder = new ComparePointsBySlope();

   /** x,y coordinates of this point. */
   private final int x;
   private final int y;

   /** 
    * Create a point from the given x and y coordinates. If either x or y is
    * negative, throw an IllegalArgumentException.
    */
   public Point(int x, int y) {
      if (x < 0 || y < 0) {
         throw new IllegalArgumentException("Points must occupy quadrant 1");
      }
      this.x = x;
      this.y = y;
   }

   /** 
    * Return a string representation of this point.
    * 
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override
   public String toString() {
      return "(" + x + ", " + y + ")";
   }

   /**
    * Indicates whether some object is equal to this Point. A Point (x1, y1) is
    * equal to this Point (x0, y0) if and only if x0 == x1 and y0 == y1. All
    * six properties of the equals method specified in the Object class are
    * met.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (!(obj instanceof Point)) {
         return false;
      }
      Point that = (Point) obj;
      return (this.x == that.x) && (this.y == that.y);
   }

   /**
    * Compares this point with the specified point for order. Returns a
    * negative integer, zero, or a positive integer if this point is less
    * than, equal to, or greater than the specified point. Points are ordered
    * first by y value and then by x value. All three properties of compareTo
    * as specified in the Comparable interface are met, and this
    * implementation is consistent with equals.
    */
   @Override
   public int compareTo(Point that) {
      if (this.y < that.y) {
         return -1;
      }
      else if (this.y > that.y) {
         return 1;
      }
      else {
         if (this.x < that.x) {
            return -1;
         }
         if (this.x > that.x) {
            return 1;
         }
         return 0;
      }
   }    

   /**
    * Computes the slope of the line segment between this point (x0, y0) and
    * the specified point (x1, y1). Slope is computed as (y1 - y0) / (x1 - x0),
    * so the direction of the slope is from this point to the specified point.
    * The slope of a horizontal line segment is positive zero; the slope of a
    * vertical line segment is positive infinity; the slope of a degenerate
    * line segment (where this point and the specified point are the same) is
    * negative infinity.
    */
   public double slopeTo(Point that) {
      if (this.equals(that)) {
         return Double.NEGATIVE_INFINITY;
      }
      if (this.x == that.x) {
         return Double.POSITIVE_INFINITY;
      }
      if (this.y == that.y) {
         return 0.0;
      }
      // Creates value for calculation /
      int up = that.y - this.y;
      int over = that.x - this.x;
      return ((double) up) / ((double) over);
   }
      
   /**
    * Defines a total order for Points based on the slope that two specified points
    * make with this point.
    */
   private class ComparePointsBySlope implements Comparator<Point> {
   
      /**
       * Compares two specified points p1 and p2 for order. Returns a negative
       * integer, zero, or a positive integer if p1 is less than, equal to, or
       * greater than p2. All three properties of the compare method as
       * specified in the Comparator interface are met. 
       */
      @Override   
      public int compare(Point p1, Point p2) {
      // Calculates slopes for compare /
         double s1 = slopeTo(p1);
         double s2 = slopeTo(p2);
         if (s1 < s2) {
            return -1;
         }
         else if (s1 > s2) {
            return 1;
         }
         else {
            return 0;
         }
      }
   }
}
