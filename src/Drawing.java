import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Drawing {
    SecureRandom secureRandom = new SecureRandom();
    int n;
    int orbs = 0;
    ArrayList<Integer> urny;
    int Bn = 0;
    int Un = 0;
    int Ln = 0;
    int Cn = 0;
    int Dn = 0;
    int[] results = new int[6];

    public Drawing(int n) {
        this.n=n;
        urny = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            urny.add(0);
        }
    }

    private boolean minTwoOrbsInAllUrns() {
        int urnsWithTwoOrbs = 0;
        for (int a = 0; a < n; a++) {
            if(urny.get(a) >= 2) {
                urnsWithTwoOrbs++;
            }
        }
        return urnsWithTwoOrbs == n;
    }

    public int[] addOrbs() {
        while(orbs != n) {
            int random = secureRandom.nextInt(n);
            urny.set(random, urny.get(random) + 1);
            orbs++;
        }
        //Un & Ln
        //Calculating Un
        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(urny.get(i) == 0) {
                counter++;
            }
        }
        Un = counter;
        //Calculating Ln
        Ln = Collections.max(urny);

        //Reset
        orbs = 0;
        urny.clear();
        for (int i = 0; i < n; i++) {
            urny.add(0);
        }

        while(!minTwoOrbsInAllUrns()) {
            int random = secureRandom.nextInt(n);
            urny.set(random, urny.get(random) + 1);
            orbs++;
            //Bn & Cn
            //Calculating Bn
            if(urny.contains(2) && Bn == 0) {
                Bn = orbs;
            }
            //Calculating Cn
            if(!urny.contains(0) && Cn == 0) {
                Cn = orbs;
            }
        }
        //Calculating Dn
        Dn = orbs;

        //Getting Bn
        results[0] = Bn;
        //Getting Un
        results[1] = Un;
        //Getting Ln
        results[2] = Ln;
        //Getting Cn
        results[3] = Cn;
        //Getting Dn
        results[4] = Dn;
        //Getting Dn - Cn
        results[5] = Dn - Cn;

        return results;
    }
}
