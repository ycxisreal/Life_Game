package Logic;

import Map.MyPairs;

public interface IService {
        //更新aliveList中的活细胞
        public void CellAnalyse(int size);
        //对周围细胞计数
        public int Count(MyPairs a,int size);
}
