package p1;
import java.util.Scanner;
//Cart class
class Cart {
	public static void main(String[] args) {
		int[] price = {10,20,30};
		int[] quantity = {0,0,0};
		String[] item = {"Pen","Pencil","Eraser"};
		System.out.println("\t\t\t\t ABHICART\n");
		System.out.println("Item List\n\t1.Pen@rs10\t2.Pencil@rs20\t3.Eraser@rs30\n");
		chooseOption( item, price, quantity );
	}

	static void chooseOption(String item[],int[] price,int[] quantity) {                 //To choose correct option between 0 and 1
		int choice;
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Choose Appropriate option");
			System.out.println("1.Add item/Update Quantity");
			System.out.println("0.Generate Bill\n");
			choice = input.nextInt();
			switch(choice)
			{
			case 0 : 
			{
				caseZero( item, price, quantity );
				break;
			}
			case 1 : 
			{
				caseOne( item, price, quantity );
				break;
			}
			default : 
			{
				System.out.println("Please choose the correct option");
				chooseOption( item, price, quantity );
			}
			}
		}catch(Exception ex) {
			System.out.println("Please enter correct input");
			chooseOption( item, price, quantity );
		}

	}
	static void caseZero(String[] item,int[] price,int[] quantity) {              //To check empty items or generation of bill and exit
		int total=0;
		if( (quantity[0] == 0) && (quantity[1] == 0) && (quantity[2] == 0) ) {
			System.out.println("Bill Can't be generated, reason : Empty Cart");
			chooseOption( item, price, quantity );
		} else{
			System.out.println("Hurray! Bill Generated:");
			for( int i=0; i<3; i++ ) {
				if(quantity[i] > 0) {
					total = total + quantity[i] * price[i];
					System.out.println("Item name: "+item[i]+"\tQuantity:"+quantity[i]+"\tPrice: "+price[i]*quantity[i]);
				}
			}
			System.out.println("Grand Total: "+total);
		}
	}

	static void caseOne(String item[],int[] price,int[] quantity){                  // For Adding items in array
		int idnum,option,total=0;
		try{
			Scanner input = new Scanner(System.in);
			System.out.println("Choose id number of the item");
			idnum = input.nextInt();
			System.out.println("Set Quantity");
			option = input.nextInt();
			quantity[idnum - 1] = option;
			if( (quantity[0] == 0) && (quantity[1] == 0) && (quantity[2] == 0) ) {
				System.out.println("No items have been added to the cart");
				chooseOption( item, price, quantity);
			} else{
				for(int i=0; i<3; i++) {
					if(quantity[i] > 0) {
						total = total + quantity[i] * price[i];
						System.out.println("Item name: "+item[i]+"\tQuantity:"+quantity[i]+"\tPrice: "+price[i]*quantity[i]);
					}
				}
				chooseOption(item,price,quantity);
			}
		} catch(Exception ex) {
			System.out.println("Please enter correct input");
			caseOne(item,price,quantity);
		}
	}
}