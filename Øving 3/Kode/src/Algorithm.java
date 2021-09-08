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
            boolean hasCounted = false;
            int delepos = split(t,v,h);

            int min = t[v];
            int max = t[v];
            for(int i = v; i<=delepos-1;i++){
                if(t[i]<min) min = t[i];
                if(t[i]>max) max = t[i];

                if(max-min > delepos-1-v){
                    break;
                }
                if(i==delepos-1){
                    countsort(t, max, v,delepos-1);
                    hasCounted = true;
                }
            }

            if(!hasCounted){
                newQuicksort(t,v,delepos-1);
                hasCounted = false;
            }

            min = t[delepos+1];
            max = t[delepos+1];
            for(int i = delepos+1; i<=h;i++){
                if(t[i]<min) min = t[i];
                if(t[i]>max) max = t[i];

                if(max-min > h-(delepos+1)){
                    break;
                }
                if(i==h){
                    countsort(t,max,delepos+1, h);
                    hasCounted = true;
                }
            }

            if(!hasCounted){
                newQuicksort(t,delepos+1,h);
            }

        }
        else median3sort(t,v,h);
    }

    public static void countsort(int[] t, int k, int start, int slutt) {
        int i = start;
        int j = start;

        int[] ht = new int[k+1];
//        Bare relevant for c/c++ for alle elementer i et nytt array er null i java
//        for (i=0;i<=k;i++) ht[i]=0;
        for (;i<=slutt;i++) ++ht[t[i]];
        for(i=0;i<=k;i++) while(ht[i]-- > 0) t[j++]=i;
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
