public abstract class OpenAddress {
    public int[] table = new int[10000019];

    public abstract int probe(int h1, int i, int m);

    public int add(int number){
        int hashed = hash1(number);
        int collisions = 0;
        if(table[hashed]== 0){
            table[hashed] = number;
            return 0;
        }
        for (int i=0;i<table.length;i++){
            int i2 = i;
            int j = probe(hashed, i2, table.length);

            while(table[j] != 0){
                collisions++;
                i2++;
                j = probe(hashed, i2, table.length);
            }
            if (table[j]==0){
                table[j] = number;
                return collisions;
            }

        }
        return -1; //fullt
    }


    protected int hash1(int number){
        return number% table.length;
    }

    public void setTable(int[] table1){
        System.arraycopy(table1, 0, table, 0, table1.length);
    }

}
