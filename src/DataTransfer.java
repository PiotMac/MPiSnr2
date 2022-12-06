import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataTransfer {

    public void uruchomienie() throws FileNotFoundException {

        for (int n = 1000; n < 100001; n += 1000) {
            final String name = "mpis" + n + ".txt";
            System.out.println("#####TESTY DLA " + n + " URN#####");
            float average = 0;
            int sumBn = 0;
            int sumUn = 0;
            int sumLn = 0;
            int sumCn = 0;
            int sumDn = 0;
            int sumDCn = 0;
            File file = new File(name);
            PrintWriter printWriter = new PrintWriter(name);
            for (int k = 0; k < 50; k++) {
                Drawing draw = new Drawing(n);
                int[] tab;
                tab = draw.addOrbs();
                //Bn
                printWriter.print(tab[0] + " ");
                //Un
                printWriter.print(tab[1] + " ");
                //Ln
                printWriter.print(tab[2] + " ");
                //Cn
                printWriter.print(tab[3] + " ");
                //Dn
                printWriter.print(tab[4] + " ");
                //Dn - Cn
                printWriter.print(tab[5] + " ");
                printWriter.println();
                sumBn += tab[0];
                sumUn += tab[1];
                sumLn += tab[2];
                sumCn += tab[3];
                sumDn += tab[4];
                sumDCn += tab[5];
            }
            average = (float) (sumBn / 50.0);
            printWriter.print(average + " ");
            average = (float) (sumUn / 50.0);
            printWriter.print(average + " ");
            average = (float) (sumLn / 50.0);
            printWriter.print(average + " ");
            average = (float) (sumCn / 50.0);
            printWriter.print(average + " ");
            average = (float) (sumDn / 50.0);
            printWriter.print(average + " ");
            average = (float) (sumDCn / 50.0);
            printWriter.print(average + " ");
            printWriter.println();
            printWriter.close();
        }
    }
}
