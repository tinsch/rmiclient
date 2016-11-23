package rmi.client;

import java.rmi.Naming;

import rmi.interfaces.CalculatorInterface;

public class Client {

	public static void main(String[] args) {
		try {
			CalculatorInterface c = (CalculatorInterface) Naming.lookup("rmi://localhost:1099/calculate"); //Proxy-Object
			System.out.println(c.add(1,2));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

