package infrastructure;

import ports.Clock;

import static com.raylib.Raylib.GetFrameTime;

public class RaylibClock implements Clock {
    public double getDeltaTime(){
        return GetFrameTime();
    }
}
