public class Primes {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + N + ":");
        boolean[] primeIndexes = new boolean[N + 1];
        for (int i = 0; i <= N ; i++) {
            primeIndexes[i] = true;
        }

        int countPrimes = 0;
        // Starting with 2 as it is the first prime number, don't care about the rest.
        for (int p = 2; p * p <= N; p++) {
            if (primeIndexes[p]) {
                for (int i = p * p ; i <= N ; i +=p) {
                    primeIndexes[i] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (primeIndexes[i]) {
                countPrimes++;
                System.out.println(i);
            }
        }

        System.out.println("There are " + countPrimes + " primes between 2 and " + N + " (" + ((int)(countPrimes * 100 / N)) + "% are primes)");
    }
}