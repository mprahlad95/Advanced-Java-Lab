interface A
{
    default void aa(){
        System.out.println("A; aa");
    }
}
  
interface B
{
    default void bb(){
        System.out.println("B; bb");
    }
}
  
public class multi_inheritence implements A, B 
{
    public static void main(String[] args) 
    {
    	multi_inheritence self = new multi_inheritence();
         
        self.aa();
        self.bb();
    }
}