
public class StringTree {

	Node root;
	
	public StringTree()
	{
		root = null;
	}
	
	public void addNode(String fruits_veggies)
	{
		root = addNode(root, fruits_veggies);
	}
	
	private Node addNode(Node p_node, String fruits_veggies)
	{
		if (p_node == null)
		{
			p_node = new Node(fruits_veggies);
		}
		//add to left if greater or equal to root fruit
		else if (p_node.value.compareTo(fruits_veggies) >= 0) 
		{
		     p_node.left = addNode(p_node.left, fruits_veggies);
		}
		else if (p_node.value.compareTo(fruits_veggies) < 0) 
		{
		     p_node.right = addNode(p_node.right, fruits_veggies);
		} 
		
		return p_node;	
	}

	public void inorder(Node p_node)
	{
		if (p_node != null)
		{
			inorder(p_node.left);
			System.out.print(p_node.value + "\n");
			inorder(p_node.right);
		}
	}
	
	
}
