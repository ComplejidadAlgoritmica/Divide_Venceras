package co.edu.unbosque.model;

import java.math.BigInteger;

public class Karatsuba {

	public BigInteger karatsubaBi(BigInteger x, BigInteger y) {

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
        BigInteger ac    = karatsubaBi(a, c);
        BigInteger bd    = karatsubaBi(b, d);
        BigInteger abcd  = karatsubaBi(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
	
	public long karatsuba(long num1, long num2) {
		// Condición de terminación recursiva
		if (num1 < 10 || num2 < 10)
			return num1 * num2;

		// Calcular longitud dividida
		int size1 = String.valueOf(num1).length();
		int size2 = String.valueOf(num2).length();
		int halfN = Math.max(size1, size2) / 2;

		long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
		long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
		long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
		long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

		// Calcula z2, z0, z1, donde la multiplicación usa recursividad
		long z2 = karatsuba(a, c);
		long z0 = karatsuba(b, d);
		long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

		return (long) (z2 * Math.pow(10, (2 * halfN)) + z1 * Math.pow(10, halfN) + z0);
	}
}
