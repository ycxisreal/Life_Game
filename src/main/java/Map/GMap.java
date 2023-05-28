package Map;

import Logic.Service;

import java.util.*;

public class GMap implements IMap {
    static public boolean[][] game_map;
    private final Service service;
    static public HashSet<MyPairs> aliveList;//存哪些方格是活的细胞，长度是活细胞的数目
    private final Random r;
    private int size;

    public GMap() {
        r = new Random();
        service = new Service();
        aliveList = new HashSet<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void Update() {
        game_map = new boolean[size][size];
        for (MyPairs a : aliveList)
            game_map[a.row][a.col] = true;
    }

    @Override
    public void Init() {
        if (size != 0)
            game_map = new boolean[size][size];
    }

    @Override
    public void RandomSet() {
        int num = r.nextInt(size * size);//活细胞的数目
        game_map = new boolean[size][size];
        aliveList.clear();
        for (int i = 0; i < num; i++) {
            MyPairs t = new MyPairs(r.nextInt(size), r.nextInt(size));
            game_map[t.row][t.col] = true;
            aliveList.add(new MyPairs(t.row, t.col));
        }
    }

    //分析每个活细胞与其周围的死细胞的状态，将下一回合活细胞更新保存在al中
    @Override
    public void CellUpdate() {
        service.CellAnalyse(size);
    }

    @Override
    public void draw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_map[i][j])
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.print("\r\n");
        }
    }
}
