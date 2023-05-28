package Timer;

public class Timer {
    private static int DeltaTime = 1000;//更新间隔的时间

    public static void setDeltaTime(int deltaTime) {
        Timer.DeltaTime = deltaTime;
    }

    public static int getDeltaTime() {
        return Timer.DeltaTime;
    }

}
