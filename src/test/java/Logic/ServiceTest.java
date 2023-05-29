package Logic;

import Map.GMap;
import Map.IMap;
import Map.MyPairs;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class ServiceTest {
    private final IService service =new Service();

    @Before
    public void setUp() throws Exception {
        IMap map = new GMap();
        map.setSize(4);
        map.Init();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        GMap.game_map = null;
        GMap.aliveList = null;
    }

    @Test
    public void cellAnalyse() {
        GMap.aliveList.add(new MyPairs(1,0));
        GMap.aliveList.add(new MyPairs(2,1));
        GMap.aliveList.add(new MyPairs(0,2));
        GMap.aliveList.add(new MyPairs(1,2));
        GMap.aliveList.add(new MyPairs(2,2));
        GMap.game_map[1][0] = true;
        GMap.game_map[2][1] = true;
        GMap.game_map[0][2] = true;
        GMap.game_map[1][2] = true;
        GMap.game_map[2][2] = true;
        service.CellAnalyse(4);
        assertEquals(5,GMap.aliveList.size());
        HashSet<MyPairs> test = new HashSet<>();
        test.add(new MyPairs(0,1));
        test.add(new MyPairs(2,1));
        test.add(new MyPairs(1,3));
        test.add(new MyPairs(1,2));
        test.add(new MyPairs(2,2));
        assertEquals(test,GMap.aliveList);
    }

    @Test
    public void count() {
        Random r = new Random();
        boolean isCenter = false;
        int num = r.nextInt(9);
        for (int i = 0; i < num; i++) {
            int a = r.nextInt(3);
            int b = r.nextInt(3);
            if(a==1&&b==1)
                isCenter = true;
            GMap.game_map[a][b] = true;
            GMap.aliveList.add(new MyPairs(a, b));
        }
        if(!isCenter)
            assertEquals(GMap.aliveList.size(),service.Count(new MyPairs(1,1),5));
        else
            assertEquals(GMap.aliveList.size()-1,service.Count(new MyPairs(1,1),5));
    }
}