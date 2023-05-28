package Logic;

import Map.GMap;
import Map.MyPairs;

import java.util.HashSet;

public class Service implements IService {
    @Override
    public void CellAnalyse(int size) {
        /*1.一个就死
         * 2.生命456个就死
         * 3.23个还是活
         * 4.死的周围有3个转活
         * */
        HashSet<MyPairs> temp = new HashSet<>();
        HashSet<MyPairs> theDead = new HashSet<>();
        for (MyPairs point : GMap.aliveList) {
            int num = Count(point, size);
            if (num == 2 || num == 3)
                temp.add(new MyPairs(point.row, point.col));
            //再判断死的
            for (int i = point.row - 1; i <= point.row + 1; i++) {
                for (int j = point.col - 1; j <= point.col + 1; j++) {
                    if (i < 0 || i > size - 1 || j < 0 || j > size - 1 || (i == point.row && j == point.col))
                        continue;
                    if (GMap.game_map[i][j])
                        continue;
                    theDead.add(new MyPairs(i, j));
                }
            }
        }
        for (MyPairs pairs : theDead) {
            int num = Count(pairs, size);
            if (num == 3)
                temp.add(new MyPairs(pairs.row, pairs.col));
        }
        GMap.aliveList = temp;
    }

    public int Count(MyPairs a, int size) {
        int num = 0;
        for (int i = a.row - 1; i <= a.row + 1; i++) {
            for (int j = a.col - 1; j <= a.col + 1; j++) {
                if (i < 0 || i > size - 1 || j < 0 || j > size - 1 || (i == a.row && j == a.col))
                    continue;
                if (GMap.game_map[i][j])
                    num++;
            }
        }
        return num;
    }
}
