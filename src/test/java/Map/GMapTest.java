package Map;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class GMapTest {
    private IMap m;
    @Before
    public void setUp() throws Exception {
        GMap.game_map = null;
        m = new GMap();
    }

    @Test
    public void GetSet() {
        assertEquals(0,m.getSize());
        m.setSize(10);
        assertEquals(10,m.getSize());
    }
    @Test
    public void update() {
        m.setSize(10);
        GMap.game_map = new boolean[10][10];
        Random r = new Random();
        int a = r.nextInt(10);
        int b = r.nextInt(10);
        GMap.aliveList.add(new MyPairs(a,b));
        m.Update();
        assertTrue(GMap.game_map[a][b]);
    }

    @Test
    public void init() {
        m.setSize(10);
        m.Init();
        assertNotNull(GMap.game_map);
    }

    @Test
    public void randomSet() {
        m.setSize(10);
        m.RandomSet();
        int num = 0;
        for(boolean[] a:GMap.game_map)
            for (boolean b:a)
                if(b)
                    num++;
        assertEquals(num,GMap.aliveList.size());
    }
}