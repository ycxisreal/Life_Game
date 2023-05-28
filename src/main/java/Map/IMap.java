package Map;

public interface IMap {
    public void Update();//更新地图内容

    public void Init();//初始化

    public void RandomSet();//随机生成细胞

    public void CellUpdate();//更新

    public void draw();//控制台输出查看结果来快速检查是否出错

    public int getSize();

    public void setSize(int size);
}
