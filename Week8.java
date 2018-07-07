import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
		
public class Week8 
{

	
	public static void main(String[] args) throws Exception 
	{
		StringTree fruitTree = new StringTree ();
		
		int user_choice = 0;
		int entry_method_choice;
		
		String file_value;
		String retry_file_value;
		String vegetable_choice;
		
		Scanner rescan = new Scanner(System.in);
		
		boolean correct_file_location = false;
		boolean correct_manual_entry = false;
		
		while (correct_file_location == false)
		{
	    //user includes file from computer or local project
			System.out.println("Press 1 to enter file location\nPress 2 to manually enter Strings one by one");
			
			Scanner scan = new Scanner(System.in);
			entry_method_choice = scan.nextInt();
			if (entry_method_choice == 1)
			{
				try
				{
					System.out.println("Enter file location from computer/local project:\n ");
					
					file_value = rescan.nextLine();
					Scanner fruit_file = new Scanner(new File(file_value));
				 
				    while (fruit_file.hasNextLine())
				    {
				    	file_value = fruit_file.nextLine();
				    	System.out.println("Inserting " + file_value + " from file into tree");
				    	
				    	fruitTree.addNode(file_value);
				    }//while
				    
				    correct_file_location = true;
				}//try
		
		        //if file not added, user re-enters file location or adds String vegetables manually
				catch(FileNotFoundException fileEx) 
				{
					correct_file_location = false;
					System.out.println("Error - file not found in specified location\n");
					continue;
				}
			}

			else if (entry_method_choice == 2) //allows user to enter String vegetables manually
			{   
				
				do 
				{
					System.out.println("\n-----------------------");
					System.out.println("Enter New Vegetable: ");
					
					vegetable_choice = rescan.nextLine();
					fruitTree.addNode(vegetable_choice);
					
					System.out.println(vegetable_choice + " added to tree\n");
					correct_manual_entry=false;
					while (correct_manual_entry == false)
					{
						System.out.println("Press 1 to add another String\nPress 2 to exit");
						try
						{
							
							user_choice = rescan.nextInt();
						
							rescan.nextLine(); //use leftover newline
							correct_manual_entry = true;
						}//try
						catch (InputMismatchException error)
						{
							System.out.println("Incorrect entry.");
							rescan.nextLine(); //use leftover newline
							correct_manual_entry = false;
							continue;
						}//catch

					}//inner while
					
				}while (user_choice != 2);
				
				correct_file_location = true;
			}//else if
		}//main while
		
	    System.out.println("\n-----------------------");
	    System.out.println("\nInorder tree traversal, listed alphabetically:\n");
		
	    fruitTree.inorder(fruitTree.root);	
		
	}//main
	
}//class

