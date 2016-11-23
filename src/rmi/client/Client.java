package rmi.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

import rmi.interfaces.CalculatorInterface;

public class Client {

	public static void main(String[] args) {
		try {
			CalculatorInterface c = (CalculatorInterface) Naming.lookup("rmi://localhost:1099/calculate"); //Proxy-Object
			Double x;
			Double y;
			String[] messageParts;
			String calculationMethod;
			
//			Basic test for the remote procedure call:
//			System.out.println(c.add(1.0,2.0));
//			System.out.println(c.subtract(1.0,2.0));
//			System.out.println(c.multiply(1.0,2.0));
//			System.out.println(c.divide(1.0,2.0));
			
			System.out.println("Enter calculation or exit:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String message = br.readLine();
			
			while(!message.equals("exit")) {
			    messageParts = message.split(" ");
			    calculationMethod = messageParts[0].toLowerCase();
			    x = Double.valueOf(messageParts[1]);
			    y = Double.valueOf(messageParts[2]);
			    switch (calculationMethod) {
			    	case "add": System.out.println(c.add(x, y));
		                     	break;
		            case "subtract": System.out.println(c.subtract(x, y));
		                     	break;
		            case "multiply": System.out.println(c.multiply(x, y));
	             				break;
		            case "divide": System.out.println(c.divide(x, y));
	             				break;
			    }
			    System.out.println("Enter calculation or exit:");
			    message = br.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

