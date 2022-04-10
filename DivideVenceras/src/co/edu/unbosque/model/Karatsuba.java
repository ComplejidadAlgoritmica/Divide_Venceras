package co.edu.unbosque.model;

import java.math.BigInteger;
/**
 * Esta clase se encarga de realizar una multiplicacion de numeros por dos metodos.
 * El metodo tradicional y el metodo de divide y venceras.
 * @author Santiago Flórez
 * @author Jorge Garcia
 *
 */
public class Karatsuba {

	/**
	 * Metodo que realiza la operacion de multiplicar por medio del metodo Karatsuba o el tradicional
	 * @param x Numero a ser multiplicado
	 * @param y Numero a ser multiplicado
	 * @param tipo Escoje que metodo usar para realizar la multiplicacion
	 * @return El valor final al multiplicar los numeros
	 */
	public BigInteger karatsubaBi(BigInteger x, BigInteger y, String tipo) {
		
		if(tipo.equals("K")) {
	        int N = Math.max(x.bitLength(), y.bitLength());
	        if (N <= 2000) return x.multiply(y);
	        N = (N / 2) + (N % 2);
	        BigInteger b = x.shiftRight(N);
	        BigInteger a = x.subtract(b.shiftLeft(N));
	        BigInteger d = y.shiftRight(N);
	        BigInteger c = y.subtract(d.shiftLeft(N));

	        BigInteger ac    = karatsubaBi(a, c,"K");
	        BigInteger bd    = karatsubaBi(b, d,"K");
	        BigInteger abcd  = karatsubaBi(a.add(b), c.add(d),"K");

	        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
		}else {
			BigInteger resul = x.multiply(y);
			return resul;
		}
    }
}
