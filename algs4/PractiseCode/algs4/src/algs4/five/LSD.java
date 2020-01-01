package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LSD {
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--) {
            for (int i = 0; i < N; i++)
                StdOut.println(a[i]);
            StdOut.println("=================");
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            for (int i = 0; i < N; i++)
                a[i] = aux[i];

        }
    }

    // cmd /c --% java algs4.five.LSD < ..\..\..\algs4-data\words3.txt
    public static void main(String[] args) {
        // String[] a = StdIn.readAllStrings();
        // int n = a.length;
        // int w = a[0].length();

        // // sort the strings
        // sort(a, w);
        // // print results
        // for (int i = 0; i < n; i++)
        //     StdOut.println(a[i]);
        String a="bed";
        StdOut.println(a.charAt(1)+0);
    }

    /**
bed  sob  dad  all
bug  nob  wad  bad
dad  bed  bad  bed
yes  dad  tag  bug
zoo  wad  jam  dad
now  bad  rap  dim
for  wee  tap  dug
tip  fee  tar  egg
ilk  bug  was  fee
dim  tag  jay  few
tag  egg  bed  for
jot  gig  wee  gig
sob  dug  fee  hut
nob  ilk  men  ilk
sky  owl  yes  jam
hut  all  yet  jay
men  dim  few  jot
egg  jam  egg  joy
few  men  gig  men
jay  zoo  dim  nob
owl  tip  tip  now
joy  rap  sky  owl
rap  tap  ilk  rap
gig  for  all  sky
wee  tar  sob  sob
was  yes  nob  tag
wad  was  zoo  tap
fee  jot  for  tar
tap  hut  jot  tip
tar  yet  now  wad
dug  now  joy  was
jam  few  bug  wee
all  sky  dug  yes
bad  jay  hut  yet
yet  joy  owl  zoo
     */
}