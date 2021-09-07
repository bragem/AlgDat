public class Algorithm {
    public static void quicksort(int []t, int v, int h){
        if(h-v > 2){
            int delepos = split(t,v,h);
            quicksort(t,v,delepos-1);
            quicksort(t,delepos+1,h);
        }
        else median3sort(t,v,h);
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
