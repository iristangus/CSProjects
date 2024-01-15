public class Child extends Parent

{
	
	public static void main(String[] args) {
		Parent c1 = new Parent();

		Child c2 = new Child();

		Parent c3 = new Child();
		
		((Child) c1).methodThree();
	}

 public void methodOne()

 {

   System.out.print("C");

   super.methodOne();

 }

 public void methodTwo()

 {

   System.out.print("D");  

   super.methodTwo();

 }

public void methodThree() {

  System.out.println("E");

  super.methodTwo();

 }

}