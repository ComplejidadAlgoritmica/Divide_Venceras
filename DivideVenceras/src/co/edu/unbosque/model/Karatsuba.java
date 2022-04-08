package co.edu.unbosque.model;

import java.math.BigInteger;

public class Karatsuba {

	public BigInteger karatsubaBi(BigInteger x, BigInteger y, String tipo) {
		
		if(tipo.equals("K")) {
			// cutoff to brute force
	        int N = Math.max(x.bitLength(), y.bitLength());
	        if (N <= 2000) return x.multiply(y);                // optimize this parameter

	        // number of bits divided by 2, rounded up
	        N = (N / 2) + (N % 2);

	        // x = a + 2^N b,   y = c + 2^N d
	        BigInteger b = x.shiftRight(N);
	        BigInteger a = x.subtract(b.shiftLeft(N));
	        BigInteger d = y.shiftRight(N);
	        BigInteger c = y.subtract(d.shiftLeft(N));

	        // compute sub-expressions
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
