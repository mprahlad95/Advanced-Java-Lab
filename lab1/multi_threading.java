class multi_threading implements Runnable{  
  public void run(){  
    System.out.println("Thread is running");  
  }   
  public static void main(String args[]){  
	 multi_threading obj=new multi_threading();  
     Thread tobj =new Thread(obj);  
     tobj.start();  
 }  
}