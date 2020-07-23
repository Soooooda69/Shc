public class DrawTriangle {
   public static void drawTriangle(int n){
   int i=0;
   String t="*";
      while (i<n){
      System.out.println(t);
         i+=1;
         t+="*";
      }
   }
   public static void main(String[] args) {
      drawTriangle(10);
   }
}