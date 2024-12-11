package dataStructures;
import java.lang.classfile.components.ClassPrinter.Node;
import java.util.*;
enum ExpressionType{
	INFIX,
	PREFIX,
	POSTFIX;
}
public class Expression extends LinkedBinaryTree{
	
	private String notationExp;
	private ExpressionType eType;
	Scanner scan;
	
	public Expression() {
		super();
		notationExp="";
		eType = ExpressionType.INFIX;
		scan = new Scanner(System.in);
	}
	
	public void readInfixExpression() {
		eType = ExpressionType.INFIX;
		System.out.println(eType + " Илэрхийлэл оруулна уу! Operand болон " + " операторуудыг 1 хоосон зайтай оруулаарай!");
	    this.notationExp = scan.nextLine();
		
	}
    
	public void readPostfixExpression() {
		eType = ExpressionType.POSTFIX; 
		System.out.println(eType + " Илэрхийлэл оруулна уу! Operand болон " + " операторуудыг 1 хоосон зайтай оруулаарай!");
	    this.notationExp = scan.nextLine();
	}
	
    public void readPrefixExpression() {
    	eType = ExpressionType.PREFIX;
		System.out.println(eType + " Илэрхийлэл оруулна уу! Operand болон " + " 	аторуудыг 1 хоосон зайтай оруулаарай!");
	    this.notationExp = scan.nextLine();
	}
    
    private int Prec(char ch)
    {
    	switch (ch) {
    	case '+':
    	case '-':
    		return 1;
    	case '*':
    	case '/':
    		return 2;
    	case '^':
    		return 3;
    	}
    	return -1;
    	
    }
    
    class BinaryTreeNode {
	    String value; // Оператор эсвэл операнд (operand or operator)
	    BinaryTreeNode left, right; // Зүүн болон баруун дэд мод руу заагч

	    BinaryTreeNode(String value) {
	        this.value = value;
	        this.left = null;
	        this.right = null;
	    }
	}
    
    class Node {
	    String value; // Оператор эсвэл операнд
	    Node left, right;

	    Node(String value) {
	        this.value = value;
	        this.left = null;
	        this.right = null;
	    }
	}
    
    public void infixToPostfix() {
		if(eType == ExpressionType.INFIX) {
			eType = ExpressionType.POSTFIX;
		String result = new String("");
		ArrayStack stack = new ArrayStack();
		String [] elems = notationExp.split(" ");
		
		for(int i = 0; i < elems.length; i++) {
			if(Character.isLetterOrDigit(elems[i].charAt(0)))
				result += elems[i]+" ";
			
			else if(elems[i].charAt(0) == '(')
				stack.push(elems[i]);
			else if(elems[i].charAt(0) == ')') {
				while(!stack.empty() && stack.peek().toString().charAt(0) != '(') {
					result += stack.peek()+" ";
					stack.pop();
				}
			stack.pop();
		}

		else
		{
			while(!stack.empty() && Prec(elems[i].charAt(0)) <= Prec(stack.peek().toString().charAt(0))) {
				result += stack.peek()+" ";
				stack.pop();
			}
			stack.push(elems[i]);
		}
		}
		
		while(!stack.empty()) {
			if(stack.peek().toString().charAt(0) == '(')
				System.out.println("Буруу илэрхийлэл");
			result += stack.peek()+" ";
			stack.pop();
		}
		this.notationExp = result;
	}
    }
    public void prefixToPostfix() {
    	if(eType == ExpressionType.PREFIX) {
    		eType = ExpressionType.POSTFIX;
    		String result = new String("");
    		ArrayStack stack = new ArrayStack();
    		String [] elems = notationExp.split(" ");
    		
    		for(int i = elems.length - 1; i >= 0; i--)
    		{
    			if(elems[i].length()==1 && !Character.isLetterOrDigit(elems[i].charAt(0)))
    			{
    				String op1 = stack.peek().toString();
    				stack.pop();
    				String op2 = stack.peek().toString();
    				stack.pop();
    				
    				String temp = op1 + op2 + elems[i].charAt(0)+" ";
    				stack.push(temp);
    			}
    			else {
    				stack.push(elems[i] + " ");
    			}
    		}
    		this.notationExp = stack.peek().toString();
    	}
		
	}
    
    public void expressionTreeFromPostfix() {
    	ArrayStack stN = new ArrayStack();
    	Expression t1,t2,temp;
    	String[] elems = notationExp.split(" ");
    	
    	for(int i = 0; i <elems.length; i++) {
    		if(Character.isLetterOrDigit(elems[i].charAt(0))){
    			temp = new Expression();
    			temp.makeTree(elems[i], temp, temp);
    			stN.push(temp);
    		}
    		else {
    			temp = new Expression();
    			t1 =(Expression)stN.pop();
    			t2 =(Expression)stN.pop();
    			temp.makeTree(elems[i].charAt(0), t2, t1);
    			stN.push(temp);
    		}
    	}
    	temp = (Expression)stN.pop();
    	this.root = temp.root;
    }
    
    public void bodoh() {
    
    }

    public void menu() {
    	System.out.println("\n---Menu---");
    	System.out.println("1) Infix илэрхийлэл оруулах");
    	System.out.println("2) Prefix илэрхийлэл оруулах");
    	System.out.println("3) Postfix илэрхийлэл оруулах");
    	System.out.println("4) Postfix илэрхийлэл хэвлэх");
    	System.out.println("5) Prefix илэрхийлэл хэвлэх");
    	System.out.println("6) Infix илэрхийлэл хэвлэх");
    	System.out.println("7) Илэрхийлэл бодох");
    	System.out.println("---Үйлдлийн дугаар сонгоорой---");
    }



	public static void main(String[] args) {
		try {
			Expression myexp = new Expression();
			int command;
			while(true)
			{
				myexp.menu();
				command = Integer.parseInt(myexp.scan.nextLine());
    		switch(command) 
    		{
    		case 1:
    			myexp.readInfixExpression();
    			myexp.infixToPostfix();
    			myexp.expressionTreeFromPostfix();
    		    break;
    		case 2:
    			myexp.readPrefixExpression();
    			myexp.prefixToPostfix();
    			myexp.expressionTreeFromPostfix();
        		break;
    		case 3:
    			myexp.readPostfixExpression();
    			myexp.expressionTreeFromPostfix();
        		break;
    		case 4:
    			System.out.println("\n Postfix илэрхийлэл");
    			myexp.postOrderOutput();
        		break;
    		case 5:
    			System.out.println("\n Prefix илэрхийлэл");
    			myexp.preOrderOutput();
        		break;
    		case 6:
    			System.out.println("\n Infix илэрхийлэл");
    			myexp.inOrderOutput();
        		break;
    		case 7:
    			
    		}		
        }
    }
		catch(Exception ex) {
		System.out.println("Error"+ex.getMessage());
		}
}

}

