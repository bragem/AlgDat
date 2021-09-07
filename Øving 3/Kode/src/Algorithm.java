public class Algorithm {
    public static void quicksort(int []t, int v, int h){
        if(h-v > 2){
            int delepos = split(t,v,h);
            quicksort(t,v,delepos-1);
            quicksort(t,delepos+1,h);
        }
        else median3sort(t,v,h);
    }

    public static void newQuicksort(int[] t, int v, int h){
        if(h-v > 2){
            int delepos = split(t,v,h);

            for(int i = 0; i<delepos-1;i++){
                int min = t[0];
                int max = t[0];

                if(t[i]<min) min = t[i];
                if(t[i]>max) max = t[i];

                if(max-min > delepos-1){
                    newQuicksort(t,v,delepos-1);
                    break;
                }
                if(i==delepos-2){
                    countsort(t, max);
                }
            }

            for(int i = delepos+1; i<t.length;i++){
                int min = t[delepos+1];
                int max = t[delepos+1];

                if(t[i]<min) min = t[i];
                if(t[i]>max) max = t[i];

                if(max-min > delepos-1){
                    newQuicksort(t,delepos+1,h);
                    break;
                }
                if(i==delepos-2){
                    countsort(t,max);
                }
            }

        }
        else median3sort(t,v,h);
    }

    public static int[] countsort(int[] t, int k) {
        int i,j, n = t.length;
        int[] ht = new int[k+1];
        for (i=0;i<=k;i++) ht[i]=0;
        for (i=0;i<n;i++) ++ht[t[i]];
        for(i=j=0;i<=k;i++) while(ht[i]-- > 0) t[j++]=i;
        return t;
    }

    private static int median3sort(int[] t, int v, int h) {
        int m = (v+h)/2;
        if(t[v] > t[m]) swap(t,v,m);
        if(t[m] > t[h]){
            swap(t, m, h);
            if(t[v] > t[m]) swap(t, v, m);
        }
        return m;
    }

    private static int split(int[] t, int v, int h) {
        int iv;
        int ih;
        int m = median3sort(t, v, h);
        int dv = t[m];
        swap(t, m, h-1);
        for(iv = v, ih = h-1;;){
            while(t[++iv] < dv);
            while(t[--ih] > dv);
            if(iv >= ih) break;
            swap(t,iv,ih);
        }
        swap(t,iv,h-1);
        return iv;
    }

    private static void swap(int[] t, int i, int j) {
        int k = t[j];
        t[j] = t[i];
        t[i] = k;
    }
}
